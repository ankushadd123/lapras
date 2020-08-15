package com.lapras.cv.service;

import com.lapras.cv.model.cv.ResumeFormDTO;

import javax.servlet.http.HttpServletResponse;

public interface CVService {

    public byte[] generate(ResumeFormDTO resumeFormDTOForm);

    public byte[] generateSampleCV();
}
