package br.com.braulioti.data.dto;

import java.io.Serializable;
import java.util.Objects;

public class UploadFileResponseDTO  implements Serializable {

    private static final long serialVersionUID = 1L;

    private String fileName;
    private String fileType;
    private Long size;
    private String fileDownloadUri;

    public UploadFileResponseDTO(String fileName, String fileDownloadUri, String fileType, Long size) {
        this.fileName = fileName;
        this.fileDownloadUri = fileDownloadUri;
        this.fileType = fileType;
        this.size = size;
    }

    public UploadFileResponseDTO() { }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getFileDownloadUri() {
        return fileDownloadUri;
    }

    public void setFileDownloadUri(String fileDownloadUri) {
        this.fileDownloadUri = fileDownloadUri;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UploadFileResponseDTO that = (UploadFileResponseDTO) o;
        return Objects.equals(fileName, that.fileName) && Objects.equals(fileType, that.fileType) && Objects.equals(size, that.size) && Objects.equals(fileDownloadUri, that.fileDownloadUri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileName, fileType, size, fileDownloadUri);
    }
}
