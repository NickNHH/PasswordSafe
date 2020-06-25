package bbw.ch.passwordSafe;


import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class MyServiceTest {

    @Mock private MyDao myDao;

    @Rule public MockitoRule rule = MockitoJUnit.rule();

    @Test
    public void testFindById() {
        MockitoAnnotations.initMocks(this);
        MyService myService = new MyService(myDao);
        myService.findById(1L);
        Mockito.verify(myDao).findById(1L);
    }

    @Test
    public void test() {
        MyService myService = new MyService(myDao);
        Mockito.when(myDao.findById(1L)).thenReturn(createTestEntity());
        Entry actual = myService.findById(1L);
        Assert.assertEquals(1, actual.getId());
        Assert.assertEquals("youtube.com", actual.getUrl());
        Assert.assertEquals("PW1234", actual.getPassword());
        Mockito.verify(myDao).findById(1L);
    }

    private Entry createTestEntity() {
        Entry entry = new Entry();
        entry.setId(1);
        entry.setUrl("youtube.com");
        entry.setPassword("PW1234");
        return entry;
    }
}
