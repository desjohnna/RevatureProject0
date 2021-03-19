package test_services;

import dev.gray.building_log_models.Employee;
import dev.gray.controllers.UserController;
import dev.gray.repos.UserRepository;
import dev.gray.services.LoginServiceImpl;
import dev.gray.token.AuthRequest;
import dev.gray.token.AuthResponse;
import dev.gray.token.TokenManager;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LoginServiceImplTest {


    @InjectMocks
//    private UserController userController;

    private LoginServiceImpl loginService;

    @Mock
    private UserRepository repository;
    private TokenManager manager;

    @BeforeEach
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }


    @BeforeClass
    public void setup() {
        repository = mock(UserRepository.class);
        manager = mock(TokenManager.class);
        loginService = new LoginServiceImpl(repository, manager);
    }

    @Test
    public void loginTest() {
        final AuthRequest request = new AuthRequest("user@email.com", "secret");
        final String token = "token";
        final Employee user = new Employee(1, "user@email.com", "secret");
        when(repository.findByEmail("user@email.com")).thenReturn(Optional.of(user));
//        when(manager.issueToken(Integer.toString(user.getUserId()))).thenReturn(token);

//        AuthResponse result = loginService.signup(request);
//        assertNotNull(result);
//        assertEquals(result.getToken(), token);

    }

    @Test
    public void signupTest() {
        final AuthRequest request = new AuthRequest("user@email.com", "secret");
        final String token = "token";
        final Employee user = new Employee(1, "user@email.com", "secret");
        when(repository.signup("user@email.com", "secret")).thenReturn(user);
        AuthResponse result = loginService.signup(request);
        assert(result.getToken().equals(token));
        assert(result.getToken()).matches(token);
    }

//    @Test
//    public void loginTest() {
//        final AuthRequest request = new AuthRequest("user@email.com", "secret");
//        final String token = "token";
//        final User user = new User("userId", "user@email.com", "secret");
//        EasyMock.expect(repository.findByEmail("user@email.com")).andReturn(Optional.of(user));
//        EasyMock.expect(manager.issueToken(user.getUserId())).andReturn(token);
//        EasyMock.replay(repository, manager);
//        AuthResponse result = service.login(request);
//        assertThat(result).isNotNull();
//        assertThat(result.getToken()).isEqualTo(token);
//    }
//
//    @Test
//    public void loginDeniedTest() {
//        final AuthRequest request = new AuthRequest("user@email.com", "secret");
//        EasyMock.expect(repository.findByEmail("user@email.com")).andReturn(Optional.empty());
//        EasyMock.replay(repository);
//        AuthResponse result = service.login(request);
//        assertThat(result).isNotNull();
//    }
//
//    @Test
//    public void authorizeTest() {
//        String token = "token";
//        String userId = "userId";
//        EasyMock.expect(manager.authorize(token, userId)).andReturn(true);
//        EasyMock.replay(manager);
//        boolean result = service.authorize(token, userId);
//        assertThat(result).isTrue();
//    }
//
//    @Test
//    public void authorizeDeniedTest() {
//        String token = "token";
//        String userId = "userId";
//        EasyMock.expect(manager.authorize(token, userId)).andReturn(false);
//        EasyMock.replay(manager);
//        boolean result = service.authorize(token, userId);
//        assertThat(result).isFalse();
//    }

}
