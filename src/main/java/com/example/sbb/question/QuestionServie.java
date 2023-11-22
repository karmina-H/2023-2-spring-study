package com.example.sbb.question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.example.sbb.DataNotFoundException;

@RequiredArgsConstructor
@Service
public class QuestionServie {
    private final QuestionRepository questionRepository;

    public List<Question> getlist(){
        return this.questionRepository.findAll();
    }

    public Question getQuestion(Integer id){
        Optional<Question> question = this.questionRepository.findById(id);
        if(question.isPresent()){
            return question.get();
        }else{
            throw new DataNotFoundException("Qquestion not found");
        }
    }
}
