package com.lapras.cv.service.serviceImpl;

import com.lapras.cv.model.cv.*;
import com.lapras.cv.pdf.format.AddressHeader;
import com.lapras.cv.pdf.header.*;
import com.lapras.cv.service.CVService;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class CVServiceImpl implements CVService {

    @Override
    public byte[] generate(ResumeFormDTO resumeFormDTOForm) {
        Document document = new Document();
        ByteArrayOutputStream data = new ByteArrayOutputStream();
        try {
            ResumeFormDTO resumeFormDTO = resumeFormDTOForm;
//            ResumeFormDTO resumeFormDTO = new ResumeFormDTO(true);
            PdfWriter writer = PdfWriter.getInstance(document, data);
            document.open();
            PdfPTable address = getAddress(resumeFormDTO.getAddress());
            PdfPTable education = getEducation(resumeFormDTO.getEducations());
            PdfPTable introduction = getIntroduction(resumeFormDTO.getIntroduction());
//            PdfPTable experienceAndProject = getExperienceAndProjects(resumeFormDTO.getExperience(), resumeFormDTO.getProjects());

            document.add(address);
            document.add(education);
//            document.add(experienceAndProject);
            document.add(introduction);

            document.close();
            writer.close();
            return Base64.getEncoder().encode(data.toByteArray());
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return new ByteArrayOutputStream().toByteArray();
    }

    @Override
    public byte[] generateSampleCV() {
        return generate(new ResumeFormDTO());
    }

    private PdfPCell getDefaultCell() {
        PdfPCell cell = new PdfPCell();
//        cell.setBorderWidthTop(1);
//        cell.setBorderWidthBottom(1);
//        cell.setBorderWidthLeft(1);
//        cell.setBorderWidthRight(1);
        cell.setBorderWidthTop(0);
        cell.setBorderWidthBottom(0);
        cell.setBorderWidthLeft(0);
        cell.setBorderWidthRight(0);
//        cell.setBackgroundColor(BaseColor.YELLOW);
        return cell;
    }

    private PdfPCell getDefaultCell(boolean t) {
        PdfPCell cell = new PdfPCell();
//        cell.setBorderWidthTop(1);
//        cell.setBorderWidthBottom(1);
//        cell.setBorderWidthLeft(1);
//        cell.setBorderWidthRight(1);
        cell.setBorderWidthTop(0);
        cell.setBorderWidthBottom(0);
        cell.setBorderWidthLeft(0);
        cell.setBorderWidthRight(0);
//        cell.setBackgroundColor(BaseColor.YELLOW);
        return cell;
    }

    private PdfPCell getEmptyCell() {
        PdfPCell cell = new PdfPCell();
//        cell.setBorderWidthTop(1);
//        cell.setBorderWidthBottom(1);
//        cell.setBorderWidthLeft(1);
//        cell.setBorderWidthRight(1);
//        cell.setBackgroundColor(BaseColor.YELLOW);
        cell.setBorderWidthTop(0);
        cell.setBorderWidthBottom(0);
        cell.setBorderWidthLeft(0);
        cell.setBorderWidthRight(0);

        cell.addElement(new Chunk(" "));
        return cell;
    }

    private PdfPCell getEmptyCell(boolean t) {

        PdfPCell cell = new PdfPCell();
//        cell.setBorderWidthTop(1);
//        cell.setBorderWidthBottom(1);
//        cell.setBorderWidthLeft(1);
//        cell.setBorderWidthRight(1);
//        cell.setBackgroundColor(BaseColor.YELLOW);
        cell.setBorderWidthTop(0);
        cell.setBorderWidthBottom(0);
        cell.setBorderWidthLeft(0);
        cell.setBorderWidthRight(0);

        cell.addElement(new Chunk(" "));
        return cell;
    }

    private PdfPTable getAddress(AddressDTO addressDTO) {

        int mobAndEmailLeftPadding = 45;
        int mobAndEmailBottomPadding = 20;
        PdfPCell name = getDefaultCell();
        name.addElement(new NameFormat(addressDTO.getName()));

        PdfPCell mobile = getDefaultCell();
        mobile.setPaddingLeft(mobAndEmailLeftPadding);
        mobile.addElement(new Paragraph(addressDTO.getMobile()));

        PdfPCell address = getDefaultCell();
        address.setBorderWidthBottom(3);
        address.setBorderColorBottom(BaseColor.GRAY);
        address.setUseBorderPadding(true);
        address.setPaddingBottom(mobAndEmailBottomPadding);
        address.addElement(new Paragraph(addressDTO.getCurrentCity()));

        PdfPCell email = getDefaultCell();
        email.setPaddingLeft(mobAndEmailLeftPadding);
        email.setPaddingBottom(mobAndEmailBottomPadding);
        email.setBorderWidthBottom(3);
        email.setUseBorderPadding(true);
        email.setBorderColorBottom(BaseColor.GRAY);
        email.addElement(new Paragraph(addressDTO.getEmail()));

        PdfPTable addressTable = new AddressHeader(Arrays.asList(name, mobile, address, email), 2);

        addressTable.addCell(getEmptyCell());
        addressTable.addCell(getEmptyCell());
        addressTable.addCell(getEmptyCell());
        addressTable.addCell(getEmptyCell());

        return addressTable;
    }

    private PdfPTable getIntroduction(IntroductionDTO introductionDTO) {

        int padding = 15;

        PdfPTable introductionTable = new PdfPTable(2);
        introductionTable.setWidthPercentage(100);

        PdfPCell fatherTitle = getDefaultCell(true);
        fatherTitle.setPaddingRight(padding);
        fatherTitle.addElement(new IntroductionFormat("Father's name    :", Element.ALIGN_RIGHT));

        PdfPCell fatherName = getDefaultCell(true);
//        fatherName.setPaddingLeft(padding);
        fatherName.addElement(new IntroductionFormat(introductionDTO.getFatherName(), Element.ALIGN_LEFT));

        PdfPCell hobbiesTitle = getDefaultCell(true);
        hobbiesTitle.setPaddingRight(padding);
        hobbiesTitle.addElement(new IntroductionFormat("Hobbies    :", Element.ALIGN_RIGHT));

        PdfPCell hobbies = getDefaultCell(true);
//        hobbies.setPaddingLeft(padding);
        hobbies.addElement(new IntroductionFormat(introductionDTO.getHobbies(), Element.ALIGN_LEFT));

        PdfPCell dobTitle = getDefaultCell(true);
        dobTitle.setPaddingRight(padding);
        dobTitle.addElement(new IntroductionFormat("Date of Birth    :", Element.ALIGN_RIGHT));

        PdfPCell dob = getDefaultCell(true);
//        dob.setPaddingLeft(padding);
        dob.addElement(new IntroductionFormat(introductionDTO.getDateOfBirth(), Element.ALIGN_LEFT));

        PdfPCell alternateContactTitle = getDefaultCell(true);
        alternateContactTitle.setPaddingRight(padding);
        alternateContactTitle.addElement(new IntroductionFormat("Alternate Contact number    :", Element.ALIGN_RIGHT));

        PdfPCell alternateContact = getDefaultCell(true);
//        alternateContact.setPaddingLeft(padding);
        alternateContact.addElement(new IntroductionFormat(introductionDTO.getAlternateContactNumber(), Element.ALIGN_LEFT));

        PdfPCell addressTitle = getDefaultCell(true);
        addressTitle.setPaddingRight(padding);
        addressTitle.addElement(new IntroductionFormat("Address    :", Element.ALIGN_RIGHT));

        PdfPCell address = getDefaultCell(true);
//        address.setPaddingLeft(padding);
        address.addElement(new IntroductionFormat(introductionDTO.getAddress(), Element.ALIGN_LEFT));

        introductionTable.addCell(fatherTitle);
        introductionTable.addCell(fatherName);
        introductionTable.addCell(hobbiesTitle);
        introductionTable.addCell(hobbies);
        introductionTable.addCell(dobTitle);
        introductionTable.addCell(dob);

        introductionTable.addCell(addressTitle);
        introductionTable.addCell(address);
        introductionTable.addCell(alternateContactTitle);
        introductionTable.addCell(alternateContact);

        introductionTable.addCell(getEmptyCell(true));
        introductionTable.addCell(getEmptyCell(true));
        introductionTable.addCell(getEmptyCell(true));
        introductionTable.addCell(getEmptyCell(true));
        introductionTable.addCell(getEmptyCell(true));
        introductionTable.addCell(getEmptyCell(true));

        PdfPCell thanks = getDefaultCell(true);
        thanks.setColspan(2);
//        thanks.setPaddingRight(padding);
        thanks.addElement(new IntroductionFormat("Thanks and Regards", Element.ALIGN_LEFT));
        introductionTable.addCell(thanks);

        return introductionTable;

    }

    private PdfPTable getEducation(List<EducationDTO> educationDTOs) {

//        PdfPTable educationTable = new PdfPTable(5);
        PdfPTable educationTable = new PdfPTable(new float[]{1.5f, 1.5f, 1, 1, 1});
        educationTable.setWidthPercentage(100);
        float borderWidth = 0.5f;

        addEducationDefaultHeading(educationTable);

        educationDTOs.forEach(educationDTO -> {

            PdfPCell universityBoard = getDefaultCell();
            universityBoard.setBorderWidthLeft(borderWidth);
//            universityBoard.setBorderWidthTop(borderWidth);
            universityBoard.setBorderWidthBottom(borderWidth);
            universityBoard.setBorderWidthRight(borderWidth);
            universityBoard.addElement(new EducationFormat(educationDTO.getUniversityBoard()));

            PdfPCell standardDegree = getDefaultCell();
//            standardDegree.setBorderWidthLeft(borderWidth);
//            standardDegree.setBorderWidthTop(borderWidth);
            standardDegree.setBorderWidthBottom(borderWidth);
            standardDegree.setBorderWidthRight(borderWidth);
            standardDegree.addElement(new EducationFormat(educationDTO.getStandardDegree()));

            PdfPCell startYear = getDefaultCell();
//            startYear.setBorderWidthLeft(borderWidth);
//            startYear.setBorderWidthTop(borderWidth);
            startYear.setBorderWidthBottom(borderWidth);
            startYear.setBorderWidthRight(borderWidth);
            startYear.addElement(new EducationFormat(educationDTO.getStartYear()));

            PdfPCell endYear = getDefaultCell();
//            endYear.setBorderWidthLeft(borderWidth);
//            endYear.setBorderWidthTop(borderWidth);
            endYear.setBorderWidthBottom(borderWidth);
            endYear.setBorderWidthRight(borderWidth);
            endYear.addElement(new EducationFormat(educationDTO.getEndYear()));

            PdfPCell percentage = getDefaultCell();
//            percentage.setBorderWidthLeft(borderWidth);
//            percentage.setBorderWidthTop(borderWidth);
            percentage.setBorderWidthBottom(borderWidth);
            percentage.setBorderWidthRight(borderWidth);
            percentage.addElement(new EducationFormat(educationDTO.getPercentage()));

            educationTable.addCell(universityBoard);
            educationTable.addCell(standardDegree);
            educationTable.addCell(startYear);
            educationTable.addCell(endYear);
            educationTable.addCell(percentage);
        });


        educationTable.addCell(getEmptyCell());
        educationTable.addCell(getEmptyCell());
        educationTable.addCell(getEmptyCell());
        educationTable.addCell(getEmptyCell());
        educationTable.addCell(getEmptyCell());
        educationTable.addCell(getEmptyCell());
        educationTable.addCell(getEmptyCell());
        educationTable.addCell(getEmptyCell());
        educationTable.addCell(getEmptyCell());
        educationTable.addCell(getEmptyCell());

        return educationTable;

    }

    private PdfPTable getExperienceAndProjects(ExperienceDTO experienceDTO, List<ProjectDTO> projectDTOs) {

        PdfPTable experienceTable = new PdfPTable(4);
        experienceTable.setWidthPercentage(100);
        int padding = 10;

        PdfPCell companyName = getDefaultCell(true);
        companyName.setColspan(4);
        companyName.addElement(new CompanyNameFormat(experienceDTO.getCompany() + ", " + experienceDTO.getCity()
                + " (" + experienceDTO.getStartDate() + " to " + experienceDTO.getEndDate() + ")"));
        experienceTable.addCell(companyName);

        experienceTable.addCell(getEmptyCell(true));
        experienceTable.addCell(getEmptyCell(true));
        experienceTable.addCell(getEmptyCell(true));
        experienceTable.addCell(getEmptyCell(true));

        projectDTOs.forEach(projectDTO -> {
            PdfPCell projectName = getDefaultCell(true);
            projectName.setColspan(4);
            projectName.addElement(new ProjectNameFormat(projectDTO.getProject()));
            experienceTable.addCell(projectName);

            PdfPCell projectDescription = getDefaultCell(true);
            projectDescription.setColspan(4);
            projectDescription.addElement(new Paragraph(projectDTO.getDescription()));
            experienceTable.addCell(projectDescription);

            PdfPCell toolsHeading = getDefaultCell(true);
            toolsHeading.setPaddingRight(padding);
            toolsHeading.addElement(new ToolsTechnologiesTitleFormat("Tools : "));
            experienceTable.addCell(toolsHeading);

            PdfPCell tools = getDefaultCell(true);
            tools.setColspan(3);
            tools.setPaddingLeft(padding);
            tools.addElement(new Paragraph(projectDTO.getTools()));
            experienceTable.addCell(tools);

            PdfPCell technologiesHeading = getDefaultCell(true);
            technologiesHeading.setPaddingRight(padding);
            technologiesHeading.addElement(new ToolsTechnologiesTitleFormat("Technologies : "));
            experienceTable.addCell(technologiesHeading);

            PdfPCell technologies = getDefaultCell(true);
            technologies.setColspan(3);
            technologies.setPaddingLeft(padding);
            technologies.addElement(new Paragraph(projectDTO.getTechnologies()));
            experienceTable.addCell(technologies);
        });


        experienceTable.addCell(getEmptyCell());
        experienceTable.addCell(getEmptyCell());
        experienceTable.addCell(getEmptyCell());
        experienceTable.addCell(getEmptyCell());

        return experienceTable;

    }

    private void addEducationDefaultHeading(PdfPTable educationTable) {
        float borderWidth = 0.5f;
        PdfPCell universityBoard = getDefaultCell();
//        universityBoard.width
        universityBoard.setBorderWidthLeft(borderWidth);
        universityBoard.setBorderWidthTop(borderWidth);
        universityBoard.setBorderWidthBottom(borderWidth);
        universityBoard.setBorderWidthRight(borderWidth);
        universityBoard.addElement(new EducationTitleFormat("University/Board"));

        PdfPCell standardDegree = getDefaultCell();
//        standardDegree.setBorderWidthLeft(borderWidth);
        standardDegree.setBorderWidthTop(borderWidth);
        standardDegree.setBorderWidthBottom(borderWidth);
        standardDegree.setBorderWidthRight(borderWidth);
        standardDegree.addElement(new EducationTitleFormat("Standard/Degree"));

        PdfPCell startYear = getDefaultCell();
//        startYear.setBorderWidthLeft(borderWidth);
        startYear.setBorderWidthTop(borderWidth);
        startYear.setBorderWidthBottom(borderWidth);
        startYear.setBorderWidthRight(borderWidth);
        startYear.addElement(new EducationTitleFormat("Start Year"));

        PdfPCell endYear = getDefaultCell();
//        endYear.setBorderWidthLeft(borderWidth);
        endYear.setBorderWidthTop(borderWidth);
        endYear.setBorderWidthBottom(borderWidth);
        endYear.setBorderWidthRight(borderWidth);
        endYear.addElement(new EducationTitleFormat("End Year"));

        PdfPCell percentage = getDefaultCell();
//        percentage.setBorderWidthLeft(borderWidth);
        percentage.setBorderWidthTop(borderWidth);
        percentage.setBorderWidthBottom(borderWidth);
        percentage.setBorderWidthRight(borderWidth);
        percentage.addElement(new EducationTitleFormat("Percentage"));

        educationTable.addCell(universityBoard);
        educationTable.addCell(standardDegree);
        educationTable.addCell(startYear);
        educationTable.addCell(endYear);
        educationTable.addCell(percentage);
    }

}
