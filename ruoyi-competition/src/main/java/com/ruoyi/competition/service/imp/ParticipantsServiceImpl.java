package com.ruoyi.competition.service.imp;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import com.ruoyi.competition.domain.Participants;
import com.ruoyi.competition.mapper.ParticipantsMapper;
import com.ruoyi.competition.service.IParticipantsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.Validator;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author zjh
 * @date 2024-06-18
 */
@Service
public class ParticipantsServiceImpl implements IParticipantsService
{
    @Resource
    private ParticipantsMapper participantsMapper;

    private static final Logger log = LoggerFactory.getLogger(ParticipantsServiceImpl.class);

    @Autowired
    protected Validator validator;
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Participants selectParticipantsById(Long id)
    {
        return participantsMapper.selectParticipantsById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param participants 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Participants> selectParticipantsList(Participants participants)
    {
        return participantsMapper.selectParticipantsList(participants);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param participants 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertParticipants(Participants participants)
    {
        if (!StringUtils.isNull(participants.getPassword())){
            String password = SecurityUtils.encryptPassword(participants.getPassword());
            participants.setPassword(password);
        }
        return participantsMapper.insertParticipants(participants);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param participants 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateParticipants(Participants participants)
    {
        if (!StringUtils.isNull(participants.getPassword())){
            String password = SecurityUtils.encryptPassword(participants.getPassword());
            participants.setPassword(password);
        }
        return participantsMapper.updateParticipants(participants);
    }
     @Override
    public Participants selectParticipantsByUsername(String username){
        return participantsMapper.selectParticipantsByUsername(username);
     };
    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteParticipantsByIds(Long[] ids)
    {
        return participantsMapper.deleteParticipantsByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteParticipantsById(Long id)
    {
        return participantsMapper.deleteParticipantsById(id);
    }


    @Override
    public String importParticipants(List<Participants> participantsList, Boolean isUpdateSupport)
    {
        if (StringUtils.isNull(participantsList) || participantsList.size() == 0)
        {
            throw new ServiceException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (Participants participants : participantsList)
        {
            try
            {
                // 验证是否存在这个参与者
                Participants existingParticipant = participantsMapper.selectParticipantsByUsername(participants.getUsername());
                if (existingParticipant == null)
                {
                    BeanValidators.validateWithException(validator, participants);
                    Boolean checkResult=checkIdentityAndRegistrationGroup(participants);
                    if(checkResult){
                        participants.setPassword("123456");
                        participants.setCreateTime(new Date());
                        if (!StringUtils.isNull(participants.getPassword())){
                            String password = SecurityUtils.encryptPassword(participants.getPassword());
                            participants.setPassword(password);
                        }
                        participantsMapper.insertParticipants(participants);
                        successNum++;
                        successMsg.append("<br/>" + successNum + "、账号 " + participants.getUsername() + " 导入成功");}
                }

                else if (isUpdateSupport)
                {
                    BeanValidators.validateWithException(validator, participants);

                    // 你需要根据实际情况设置更新者的信息
                    participantsMapper.updateParticipants(participants);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、账号 " + participants.getUsername() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、账号 " + participants.getUsername() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、账号 " + participants.getUsername() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e);
            }
        }
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new ServiceException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }

    public boolean checkIdentityAndRegistrationGroup(Participants participants) {
        // 验证身份是否为 "教师" 或 "评委"
        if (!"教师".equals(participants.getIdentity()) && !"评委".equals(participants.getIdentity())) {
            return false;
        }

        // 验证注册组是否为指定的几个值之一
        List<String> allowedGroups = Arrays.asList("思政课程组", "公共基础课程组（不含思政）", "专业技能课程一组", "专业技能课程二组");
        if (!allowedGroups.contains(participants.getRegistrationGroup())) {
            return false;
        }

        // 如果通过了上述验证，则返回 true
        return true;
    }
}
