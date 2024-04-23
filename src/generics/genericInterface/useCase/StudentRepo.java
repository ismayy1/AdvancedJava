package generics.genericInterface.useCase;

public class StudentRepo implements Repo <Student, Integer> {
    @Override
    public void save(Student obj) {

    }

    @Override
    public Student findById(Integer id) {
        return null;
    }
}
