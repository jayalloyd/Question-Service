package com.xyz.Question.Service.service;

import com.xyz.Question.Service.model.Question;
import com.xyz.Question.Service.model.QuestionWrapper;
import com.xyz.Question.Service.model.Response;
import com.xyz.Question.Service.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class QuestionService {
    @Autowired
    QuestionRepo repo;
    public List<Question> getAllQuestion() {
        return repo.findAll();

    }

    public List<Question>createQuestion(Question question) {
         repo.save(question);
        return repo.findAll();
    }

    public List<Question> getQuestionByCategory(String category) {
    return repo.findByCategory(category);
    }


    public ResponseEntity<List<Integer>> getQuestionForQuiz(String category, Integer numQuestions) {
        List<Integer> questions=repo.findRandomQuestionByCategory(category,numQuestions);
    return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionForId(List<Integer>questionIds) {
        List<QuestionWrapper>wrappers=new ArrayList<>();
        List<Question>questions=new ArrayList<>();
        for(Integer id: questionIds){
            questions.add(repo.findById(id).get());
        }
        for(Question question:questions){
            QuestionWrapper wrapper=new QuestionWrapper();
            wrapper.setId(question.getId());
            wrapper.setQues(question.getQues());
            wrapper.setA(question.getA());
            wrapper.setB(question.getB());
            wrapper.setC(question.getC());
            wrappers.add(wrapper);
        }
        return new ResponseEntity<>(wrappers,HttpStatus.OK);
    }

    public ResponseEntity<Integer> getScore(List<Response> responses) {

        int right=0;

        for(Response response: responses) {
            Question question = repo.findById(response.getId()).get();
            if (response.getResponse().equals(question.getRightAnswer()))


                right++;
        }
        return
                new ResponseEntity<>(right,HttpStatus.OK);
    }
}
