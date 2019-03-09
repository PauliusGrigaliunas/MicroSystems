package vu.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.lt.entities.Interview;
import vu.lt.persistence.InterviewDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Interviews{

    @Inject
    private InterviewDAO interviewDAO;

    @Getter @Setter
    private Interview interviewToCreate = new Interview();

    @Getter
    private List<Interview> allInterview;

    @PostConstruct
    public void init(){
        loadAllInterviews();
    }

    @Transactional
    public String createInterview(){
        this.interviewDAO.persist(interviewToCreate);
        return "success";
    }

    private void loadAllInterviews(){
        this.allInterview = interviewDAO.loadAll();
    }
}