package com.ruoyi.competition.controller.admin;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.competition.domain.CompetitionEntries;
import com.ruoyi.competition.domain.Refmfiles;
import com.ruoyi.competition.service.ICompetitionEntriesService;
import com.ruoyi.competition.service.IRefmfilesService;
import com.ruoyi.competition.utils.OssUtils;
import com.ruoyi.competition.vo.CompetitionShowVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin/showCompetition")
@Validated
public class CompetitionShowController extends BaseController {
    @Autowired
    private IRefmfilesService refmfilesService;
    @Autowired
    private ICompetitionEntriesService competitionEntriesService;

    @Autowired
    private OssUtils ossUtils;
    @PreAuthorize("@ss.hasPermi('admin:showCompetition:list')")
    @GetMapping("/list")
    public TableDataInfo list(@RequestBody CompetitionShowVO competitionShowVO) {
        startPage();
        CompetitionEntries competitionEntries = new CompetitionEntries();
        BeanUtils.copyProperties(competitionShowVO, competitionEntries);
        List<CompetitionEntries> list = competitionEntriesService.selectCompetitionEntriesList(competitionEntries);

        List<CompetitionShowVO> voList = list.stream().map(this::convertToVO).collect(Collectors.toList());
        return getDataTable(voList);

    }


    @GetMapping("/filePath/{fileId}")
    public AjaxResult getRefmfilePath(@PathVariable("fileId")  Long fileId){
        Refmfiles refmfiles = new Refmfiles();
        refmfiles= refmfilesService.selectRefmfilesByFileId(fileId);
        String filepath = refmfiles.getFileName();
        return AjaxResult.success(filepath);
    }


    @GetMapping("/download/{fileId}")
    public AjaxResult downloadfile(@PathVariable("fileId") Long fileId) throws Exception {
        ossUtils.downloadRefmfiles(fileId);
        return AjaxResult.success();
    }


    @Log(title = "导出", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CompetitionShowVO competitionShowVO)
    {
        CompetitionEntries competitionEntries = new CompetitionEntries();
        BeanUtils.copyProperties(competitionShowVO, competitionEntries);
        List<CompetitionEntries> list = competitionEntriesService.selectCompetitionEntriesList(competitionEntries);
        ExcelUtil<CompetitionShowVO> util = new ExcelUtil<CompetitionShowVO>(CompetitionShowVO.class);
        List<CompetitionShowVO> voList = list.stream().map(this::convertToVO).collect(Collectors.toList());
        util.exportExcel(response,voList, "导出数据数据");
    }


    private CompetitionShowVO convertToVO(CompetitionEntries competitionEntries) {
        CompetitionShowVO competitionShowVO = new CompetitionShowVO();
        BeanUtils.copyProperties(competitionEntries, competitionShowVO);
        return competitionShowVO;
    }
}
