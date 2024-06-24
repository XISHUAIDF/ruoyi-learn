package com.ruoyi.competition.controller.admin;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.competition.domain.Participants;
import com.ruoyi.competition.service.IParticipantsService;
import com.ruoyi.competition.vo.ParticipantsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Participants 管理 Controller
 *
 * @author zjh
 * @date 2024-06-18
 */
@RestController
@RequestMapping("/admin/participants")
public class AdminParticipantsController extends BaseController
{
    @Autowired
    private IParticipantsService participantsService;

    /**
     * 查询 ParticipantsVO 列表
     */
    @PreAuthorize("@ss.hasPermi('test:participants:list')")
    @GetMapping("/list")
    public TableDataInfo list(ParticipantsVO participantsVO)
    {
        startPage();
        Participants participants = new Participants();
        BeanUtils.copyProperties(participantsVO, participants);
        List<Participants> list = participantsService.selectParticipantsList(participants);
        List<ParticipantsVO> voList = list.stream().map(this::convertToVO).collect(Collectors.toList());
        return getDataTable(voList);
    }

    /**
     * 导出 ParticipantsVO 列表
     */
    @PreAuthorize("@ss.hasPermi('test:participants:export')")
    @Log(title = "导出excel", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, @RequestBody ParticipantsVO participantsVO)
    {
        Participants participants = new Participants();
        BeanUtils.copyProperties(participantsVO, participants);
        List<Participants> list = participantsService.selectParticipantsList(participants);

        List<ParticipantsVO> voList = list.stream().map(this::convertToVO).collect(Collectors.toList());
        ExcelUtil<ParticipantsVO> util = new ExcelUtil<>(ParticipantsVO.class);
        util.exportExcel(response, voList, "导出excel数据");
    }


    @PostMapping("/importData")
    public AjaxResult importParticipantsData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<Participants> util = new ExcelUtil<>(Participants.class);
        List<Participants> participantsList = util.importExcel(file.getInputStream());

        String operName = getUsername();
        String message = participantsService.importParticipants(participantsList, updateSupport);
        return AjaxResult.success(message);
    }



    /**
     * 获取 ParticipantsVO 详细信息
     */
    @PreAuthorize("@ss.hasPermi('test:participants:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        Participants participants = participantsService.selectParticipantsById(id);
        ParticipantsVO participantsVO = convertToVO(participants);
        return AjaxResult.success(participantsVO);
    }

    /**
     * 新增 ParticipantsVO
     */
    @PreAuthorize("@ss.hasPermi('test:participants:add')")
    @Log(title = "新增 Participants", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Valid @RequestBody ParticipantsVO participantsVO)
    {
        Participants participants = new Participants();
        BeanUtils.copyProperties(participantsVO, participants);
        return toAjax(participantsService.insertParticipants(participants));
    }

    /**
     * 修改 ParticipantsVO
     */
    @PreAuthorize("@ss.hasPermi('test:participants:edit')")
    @Log(title = "修改 Participants", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Valid @RequestBody ParticipantsVO participantsVO)
    {
        Participants participants = new Participants();
        BeanUtils.copyProperties(participantsVO, participants);
        return toAjax(participantsService.updateParticipants(participants));
    }

    /**
     * 删除 ParticipantsVO
     */
    @PreAuthorize("@ss.hasPermi('test:participants:remove')")
    @Log(title = "删除 Participants", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(participantsService.deleteParticipantsByIds(ids));
    }

    /**
     * 将 Participants 实体转换为 ParticipantsVO
     */
    private ParticipantsVO convertToVO(Participants participants) {
        ParticipantsVO participantsVO = new ParticipantsVO();
        BeanUtils.copyProperties(participants, participantsVO);
        return participantsVO;
    }
}
