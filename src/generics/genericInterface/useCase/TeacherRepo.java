package generics.genericInterface.useCase;

public class TeacherRepo implements Repo <Teacher, Long> {
    @Override
    public void save(Teacher obj) {

    }

    @Override
    public Teacher findById(Long id) {
        return null;
    }
}
