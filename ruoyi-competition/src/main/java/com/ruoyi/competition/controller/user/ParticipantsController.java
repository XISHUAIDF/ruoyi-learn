package com.ruoyi.competition.controller.user;


import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.competition.domain.Participants;
import com.ruoyi.competition.service.IParticipantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

/**
 * 【请填写功能名称】Controller
 * 
 * @author zjh
 * @date 2024-06-18
 */
@RestController
@RequestMapping("/test/participants")
@Validated
public class ParticipantsController extends BaseController
{
    @Autowired
    private IParticipantsService participantsService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('test:participants:list')")
    @GetMapping("/list")
    public TableDataInfo list(Participants participants)
    {
        startPage();
        List<Participants> list = participantsService.selectParticipantsList(participants);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('test:participants:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Participants participants)
    {
        List<Participants> list = participantsService.selectParticipantsList(participants);
        ExcelUtil<Participants> util = new ExcelUtil<Participants>(Participants.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('test:participants:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(participantsService.selectParticipantsById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('test:participants:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody @Valid Participants participants)
    {
        return toAjax(participantsService.insertParticipants(participants));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('test:participants:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody @Valid Participants participants)
    {
        return toAjax(participantsService.updateParticipants(participants));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('test:participants:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(participantsService.deleteParticipantsByIds(ids));
    }
}
