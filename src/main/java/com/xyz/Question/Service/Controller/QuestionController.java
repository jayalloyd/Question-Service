package com.xyz.Question.Service.Controller;

import com.xyz.Question.Service.model.Question;
import com.xyz.Question.Service.model.QuestionWrapper;
import com.xyz.Question.Service.model.Response;
import com.xyz.Question.Service.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired

    QuestionService service;


    @PostMapping("/create")
    public ResponseEntity<List<Question>> createQuestion(@RequestBody Question question) {
        List<Question> questions = service.createQuestion(question);

        // Return the questions list along with the HTTP status code
        return new ResponseEntity<>(questions, HttpStatus.CREATED);
    }

    @GetMapping("/allQuestions")
    public List<Question> getAllQuestion(){

        return  service.getAllQuestion();
    }
    @GetMapping("/category/{category}")
    public List<Question> getQuestionsByCategory(@PathVariable("category") String category){
        return service.getQuestionByCategory(category);
    }

@GetMapping("generate")
public ResponseEntity<List<Integer>>getQuestionsForQuiz(@RequestParam String category,@RequestParam Integer numQuestions)
{return  service.getQuestionForQuiz(category,numQuestions);

}
@PostMapping("getQuestion")
public ResponseEntity<List<QuestionWrapper>>getQuestionForId(@RequestBody List<Integer>questionIds){
        return service.getQuestionForId(questionIds);
}
@PostMapping("getScore")
    public ResponseEntity<Integer>getScore(@RequestBody List<Response>responses){
        return service.getScore(responses);
}
}
