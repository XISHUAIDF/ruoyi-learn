package com.ruoyi.competition.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 refmfiles
 * 
 * @author ruoyi
 * @date 2024-06-20
 */
public class Refmfiles extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 文件 ID */
    private Long fileId;

    /** 文件路径 */
    @Excel(name = "文件路径")
    private String filePath;

    /** 文件类型 */
    @Excel(name = "文件类型")
    private String fileType;

    /** 文件名 */
    @Excel(name = "文件名")
    private String fileName;

    /** 文件大小 */
    @Excel(name = "文件大小")
    private Long fileSize;


    @Excel(name = "参赛者ID")
    private Long participantsId;

    /** 文件 1:图片 2:视频 3:文件 */
    @Excel(name = "文件 1:图片 2:视频 3:文件")
    private Long type;

    public void setFileId(Long fileId) 
    {
        this.fileId = fileId;
    }

    public Long getFileId() 
    {
        return fileId;
    }
    public void setFilePath(String filePath) 
    {
        this.filePath = filePath;
    }

    public String getFilePath() 
    {
        return filePath;
    }
    public void setFileType(String fileType) 
    {
        this.fileType = fileType;
    }

    public String getFileType() 
    {
        return fileType;
    }
    public void setFileName(String fileName) 
    {
        this.fileName = fileName;
    }

    public String getFileName() 
    {
        return fileName;
    }
    public void setFileSize(Long fileSize) 
    {
        this.fileSize = fileSize;
    }

    public Long getFileSize() 
    {
        return fileSize;
    }
    public void setParticipantsId(Long participantsId) 
    {
        this.participantsId = participantsId;
    }

    public Long getParticipantsId() 
    {
        return participantsId;
    }
    public void setType(Long type) 
    {
        this.type = type;
    }

    public Long getType() 
    {
        return type;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("fileId", getFileId())
            .append("filePath", getFilePath())
            .append("fileType", getFileType())
            .append("fileName", getFileName())
            .append("fileSize", getFileSize())
            .append("participantsId", getParticipantsId())
            .append("type", getType())
            .toString();
    }
}
