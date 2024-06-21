package com.ruoyi.competition.controller;


import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.competition.domain.Refmfiles;
import com.ruoyi.competition.service.IParticipantsService;
import com.ruoyi.competition.service.IRefmfilesService;
import com.ruoyi.competition.utils.OssUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;



import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2024-06-20
 */
@RestController
@RequestMapping("/system/refmfiles")
public class RefmfilesController extends BaseController
{
    @Autowired
    private IRefmfilesService refmfilesService;


    @Autowired
    private OssUtils ossUtils;
    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:refmfiles:list')")
    @GetMapping("/list")
    public TableDataInfo list(Refmfiles refmfiles)
    {
        startPage();
        List<Refmfiles> list = refmfilesService.selectRefmfilesList(refmfiles);
        return getDataTable(list);
    }


   @PreAuthorize("@ss.hasPermi('refmfiles:upload')")
   @PostMapping("/upload")
   public AjaxResult upload(@RequestParam("file") MultipartFile file) throws IOException {
       String fileAddress=ossUtils.uploadRefmfiles(file);
       return AjaxResult.success(fileAddress);
   }

    @PreAuthorize("@ss.hasPermi('refmfiles:download')")
    @PostMapping("/download")
    public AjaxResult download(@RequestParam("fileId") Long fileId) throws Exception {
        ossUtils.downloadRefmfiles(fileId);
        return AjaxResult.success();
    }



    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:refmfiles:query')")
    @GetMapping(value = "/{fileId}")
    public AjaxResult getInfo(@PathVariable("fileId") Long fileId)
    {
        return success(refmfilesService.selectRefmfilesByFileId(fileId));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:refmfiles:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Refmfiles refmfiles)
    {
        return toAjax(refmfilesService.insertRefmfiles(refmfiles));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:refmfiles:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Refmfiles refmfiles)
    {
        return toAjax(refmfilesService.updateRefmfiles(refmfiles));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:refmfiles:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{fileIds}")
    public AjaxResult remove(@PathVariable Long[] fileIds)
    {
        return toAjax(refmfilesService.deleteRefmfilesByFileIds(fileIds));
    }
}
