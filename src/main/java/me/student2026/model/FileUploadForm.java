package me.student2026.model;

import org.jboss.resteasy.reactive.RestForm;
import org.jboss.resteasy.reactive.multipart.FileUpload;

public class FileUploadForm {

    @RestForm("filename")
    public String filename;

    @RestForm("file")
    public FileUpload file;
}
