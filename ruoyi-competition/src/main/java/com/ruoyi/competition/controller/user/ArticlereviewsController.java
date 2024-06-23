package com.ruoyi.competition.controller.user;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.competition.domain.Articlereviews;
import com.ruoyi.competition.service.IArticlereviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 作品评价Controller
 * 
 * @author ruoyi
 * @date 2024-06-21
 */
@RestController
@RequestMapping("/test/articelreviews")
public class ArticlereviewsController extends BaseController
{
    @Autowired
    private IArticlereviewsService articlereviewsService;

    /**
     * 查询作品评价列表
     */
    @PreAuthorize("@ss.hasPermi('review:articelreviews:list')")
    @GetMapping("/list")
    public TableDataInfo list(Articlereviews articlereviews)
    {
        startPage();
        List<Articlereviews> list = articlereviewsService.selectArticlereviewsList(articlereviews);
        return getDataTable(list);
    }

    /**
     * 导出作品评价列表
     */
    @PreAuthorize("@ss.hasPermi('review:articelreviews:export')")
    @Log(title = "作品评价", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Articlereviews articlereviews)
    {
        List<Articlereviews> list = articlereviewsService.selectArticlereviewsList(articlereviews);
        ExcelUtil<Articlereviews> util = new ExcelUtil<Articlereviews>(Articlereviews.class);
        util.exportExcel(response, list, "作品评价数据");
    }

    /**
     * 获取作品评价详细信息
     */
    @PreAuthorize("@ss.hasPermi('review:articelreviews:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(articlereviewsService.selectArticlereviewsById(id));
    }

    /**
     * 新增作品评价
     */
    @PreAuthorize("@ss.hasPermi('review:articelreviews:add')")
    @Log(title = "作品评价", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Articlereviews articlereviews)
    {
        return toAjax(articlereviewsService.insertArticlereviews(articlereviews));
    }

    /**
     * 修改作品评价
     */
    @PreAuthorize("@ss.hasPermi('review:articelreviews:edit')")
    @Log(title = "作品评价", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Articlereviews articlereviews)
    {
        return toAjax(articlereviewsService.updateArticlereviews(articlereviews));
    }

    /**
     * 删除作品评价
     */
    @PreAuthorize("@ss.hasPermi('review:articelreviews:remove')")
    @Log(title = "作品评价", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(articlereviewsService.deleteArticlereviewsByIds(ids));
    }
}
