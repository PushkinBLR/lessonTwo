//import Service.RegistrationService;
//import dao.UserDAOImpl;
//import entity.User;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class Tests {
//
//
//    @InjectMocks
//    RegistrationService registrationService;
//
//    @Mock
//    UserDAOImpl userdaoimplmock;
//
//    @Test
//    void createUserInNewTable() {
//        when(userdaoimplmock.createUser(User)).thenReturn(User);
//
//        registrationService.createUser(User);
//
//        verify(userdaoimplmock).createUser(User);
//    }
//}
//
