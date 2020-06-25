package bbw.ch.passwordSafe;

public class MyService {

    private MyDao myDao;

    public MyService(MyDao myDao) {
        this.myDao = myDao;
    }

    public Entry findById(long id) {
        return myDao.findById(id);
    }
}
