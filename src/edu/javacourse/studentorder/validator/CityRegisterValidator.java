package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.domain.AnswerCityRegister;
import edu.javacourse.studentorder.domain.Child;
import edu.javacourse.studentorder.domain.CityRegisterCheckerResponse;
import edu.javacourse.studentorder.domain.StudentOrder;
import edu.javacourse.studentorder.exception.CityRegisterException;

import java.util.Iterator;

public class CityRegisterValidator {

    public String hostName;
    protected int port;
    private String login;
    String password;

    private CityRegisterChecker personChecker;

    public CityRegisterValidator(){
        personChecker = new FakeCityRegisterChecker();
    }

    public AnswerCityRegister checkCityRegister(StudentOrder so){
        try{
            CityRegisterCheckerResponse hans = personChecker.checkPerson(so.getHusband());
            CityRegisterCheckerResponse wans = personChecker.checkPerson(so.getWife());
            for (int i =0;i < so.getChildren().size(); i++){
                CityRegisterCheckerResponse cans = personChecker.checkPerson(so.getChildren().get(i));
            }

            for (Iterator <Child> it = so.getChildren().iterator(); it.hasNext();){
                CityRegisterCheckerResponse cans = personChecker.checkPerson(it.next());
            }

            for (Child child :so.getChildren()){
                CityRegisterCheckerResponse cans = personChecker.checkPerson(child);
            }

        } catch (CityRegisterException ex){
            ex.printStackTrace();
        }


        AnswerCityRegister ans = new AnswerCityRegister();
        return ans;
    }
}
