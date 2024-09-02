package com.fiap.checkpoint.service;

public class UserService {
    @Service
    public class UserService {

        @Autowired
        private UserRepository userRepository;

        public User registerUser(User user) {
            if (userRepository.findByEmail(user.getEmail()).isPresent()) {
                throw new RuntimeException("E-mail já está em uso");
            }
            user.setPassword(encoder.encode(user.getPassword())); // encoder é uma instância de BCryptPasswordEncoder
            return userRepository.save(user);
        }

        public User getUserByEmail(String email) {
            return userRepository.findByEmail(email)
                    .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
        }
    }

}
