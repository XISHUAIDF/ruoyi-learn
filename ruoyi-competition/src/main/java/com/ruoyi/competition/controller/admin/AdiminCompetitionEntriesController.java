package com.ruoyi.competition.controller.admin;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.competition.domain.CompetitionEntries;
import com.ruoyi.competition.service.ICompetitionEntriesService;
import com.ruoyi.competition.vo.CompetitionEntriesVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 参赛作品Controller
 * @Author zjh
 * @Date 2024-06-18
 */
@RestController
@RequestMapping("/admin/entries")
@Validated
public class AdiminCompetitionEntriesController extends BaseController {

    @Autowired
    private ICompetitionEntriesService competitionEntriesService;

    /**
     * 查询参赛作品列表
     */
    @PreAuthorize("@ss.hasPermi('test:entries:list')")
    @GetMapping("/list")
    public TableDataInfo list(@RequestBody CompetitionEntriesVO competitionEntriesVO) {
        startPage();
        CompetitionEntries competitionEntries = new CompetitionEntries();
        BeanUtils.copyProperties(competitionEntriesVO, competitionEntries);
        List<CompetitionEntries> list = competitionEntriesService.selectCompetitionEntriesList(competitionEntries);
        List<CompetitionEntriesVO> voList = list.stream().map(this::convertToVO).collect(Collectors.toList());
        return getDataTable(voList);
    }

    /**
     * 导出参赛作品列表
     */
    @PreAuthorize("@ss.hasPermi('test:entries:export')")
    @Log(title = "参赛作品", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CompetitionEntriesVO competitionEntriesVO) {
        CompetitionEntries competitionEntries = new CompetitionEntries();
        BeanUtils.copyProperties(competitionEntriesVO, competitionEntries);
        List<CompetitionEntries> list = competitionEntriesService.selectCompetitionEntriesList(competitionEntries);
        List<CompetitionEntriesVO> voList = list.stream().map(this::convertToVO).collect(Collectors.toList());
        ExcelUtil<CompetitionEntriesVO> util = new ExcelUtil<>(CompetitionEntriesVO.class);
        util.exportExcel(response, voList, "参赛作品数据");
    }

    /**
     * 获取参赛作品详细信息
     */
    @PreAuthorize("@ss.hasPermi('test:entries:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        CompetitionEntries competitionEntries = competitionEntriesService.selectCompetitionEntriesById(id);
        CompetitionEntriesVO competitionEntriesVO = convertToVO(competitionEntries);
        return AjaxResult.success(competitionEntriesVO);
    }

    /**
     * 新增参赛作品
     */
    @PreAuthorize("@ss.hasPermi('test:entries:add')")
    @Log(title = "参赛作品", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody @Valid CompetitionEntriesVO competitionEntriesVO) {
        CompetitionEntries competitionEntries = new CompetitionEntries();
        BeanUtils.copyProperties(competitionEntriesVO, competitionEntries);
        return toAjax(competitionEntriesService.insertCompetitionEntries(competitionEntries));
    }

    /**
     * 修改参赛作品
     */
    @PreAuthorize("@ss.hasPermi('test:entries:edit')")
    @Log(title = "参赛作品", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody @Valid CompetitionEntriesVO competitionEntriesVO) {
        CompetitionEntries competitionEntries = new CompetitionEntries();
        BeanUtils.copyProperties(competitionEntriesVO, competitionEntries);
        return toAjax(competitionEntriesService.updateCompetitionEntries(competitionEntries));
    }

    /**
     * 删除参赛作品
     */
    @PreAuthorize("@ss.hasPermi('test:entries:remove')")
    @Log(title = "参赛作品", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(competitionEntriesService.deleteCompetitionEntriesByIds(ids));
    }

    /**
     * 将 CompetitionEntries 实体转换为 CompetitionEntriesVO
     */
    private CompetitionEntriesVO convertToVO(CompetitionEntries competitionEntries) {
        CompetitionEntriesVO competitionEntriesVO = new CompetitionEntriesVO();
        BeanUtils.copyProperties(competitionEntries, competitionEntriesVO);
        return competitionEntriesVO;
    }
}
