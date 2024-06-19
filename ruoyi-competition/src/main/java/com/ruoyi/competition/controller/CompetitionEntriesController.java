package com.ruoyi.competitionEntry.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.competitionEntry.domain.CompetitionEntries;
import com.ruoyi.competitionEntry.service.ICompetitionEntriesService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 参赛作品Controller
 * 
 * @author zjh
 * @date 2024-06-18
 */
@RestController
@RequestMapping("/test/entries")
public class CompetitionEntriesController extends BaseController
{
    @Autowired
    private ICompetitionEntriesService competitionEntriesService;

    /**
     * 查询参赛作品列表
     */
    @PreAuthorize("@ss.hasPermi('test:entries:list')")
    @GetMapping("/list")
    public TableDataInfo list(CompetitionEntries competitionEntries)
    {
        startPage();
        List<CompetitionEntries> list = competitionEntriesService.selectCompetitionEntriesList(competitionEntries);
        return getDataTable(list);
    }

    /**
     * 导出参赛作品列表
     */
    @PreAuthorize("@ss.hasPermi('test:entries:export')")
    @Log(title = "参赛作品", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CompetitionEntries competitionEntries)
    {
        List<CompetitionEntries> list = competitionEntriesService.selectCompetitionEntriesList(competitionEntries);
        ExcelUtil<CompetitionEntries> util = new ExcelUtil<CompetitionEntries>(CompetitionEntries.class);
        util.exportExcel(response, list, "参赛作品数据");
    }

    /**
     * 获取参赛作品详细信息
     */
    @PreAuthorize("@ss.hasPermi('test:entries:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(competitionEntriesService.selectCompetitionEntriesById(id));
    }

    /**
     * 新增参赛作品
     */
    @PreAuthorize("@ss.hasPermi('test:entries:add')")
    @Log(title = "参赛作品", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CompetitionEntries competitionEntries)
    {
        return toAjax(competitionEntriesService.insertCompetitionEntries(competitionEntries));
    }

    /**
     * 修改参赛作品
     */
    @PreAuthorize("@ss.hasPermi('test:entries:edit')")
    @Log(title = "参赛作品", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CompetitionEntries competitionEntries)
    {
        return toAjax(competitionEntriesService.updateCompetitionEntries(competitionEntries));
    }

    /**
     * 删除参赛作品
     */
    @PreAuthorize("@ss.hasPermi('test:entries:remove')")
    @Log(title = "参赛作品", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(competitionEntriesService.deleteCompetitionEntriesByIds(ids));
    }
}
