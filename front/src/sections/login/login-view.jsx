import { useState } from 'react';
import {
  Box,
  Link,
  Card,
  Stack,
  Divider,
  Typography,
  IconButton,
  InputAdornment,
} from '@mui/material';
import { useTheme, alpha } from '@mui/material/styles';
import { useRouter } from 'src/routes/hooks';
import { bgGradient } from 'src/theme/css';
import Logo from 'src/components/logo';
import Iconify from 'src/components/iconify';
import { Formik, Form, Field } from 'formik';
import { TextField } from '@mui/material';
import axios from 'axios';
import * as Yup from 'yup';
import LoadingButton from '@mui/lab/LoadingButton';
import UserStore from 'src/store/UserStore';

// ----------------------------------------------------------------------

export default function LoginView() {
  const theme = useTheme();
  const {login} = UserStore;

  const router = useRouter();

  const [showPassword, setShowPassword] = useState(false);

  const validationSchema = Yup.object().shape({
    login: Yup.string()
      .email('Введите действительный адрес электронной почты')
      .required('Это поле обязательно'),
    password: Yup.string()
      .required('Это поле обязательно'),
  });

  const handleSubmit = async (values, { setSubmitting }) => {
      const ok = await login(values);
      console.log(ok);
      if (ok) router.push('/dashboard');
      setSubmitting(false);
  };

  const renderForm = (
    <Formik
      initialValues={{ login: '', password: '' }}
      onSubmit={handleSubmit}
      validationSchema={validationSchema}
    >
      {({ isSubmitting, errors, touched }) => (
        <Form>
          <Field
            as={TextField}
            name="login"
            type="email"
            label="Email"
            variant="outlined"
            fullWidth
            margin="normal"
            error={touched.email && Boolean(errors.email)}
            helperText={touched.email && errors.email}
          />
          <Field
            as={TextField}
            name="password"
            label="Password"
            variant="outlined"
            fullWidth
            margin="normal"
            type={showPassword ? 'text' : 'password'}
            InputProps={{
              endAdornment: (
                <InputAdornment position="end">
                  <IconButton onClick={() => setShowPassword(!showPassword)} edge="end">
                    <Iconify icon={showPassword ? 'eva:eye-fill' : 'eva:eye-off-fill'} />
                  </IconButton>
                </InputAdornment>
              ),
            }}
            error={touched.password && Boolean(errors.password)}
            helperText={touched.password && errors.password}
          />
          <Stack direction="row" alignItems="center" justifyContent="flex-end" sx={{ my: 3 }}>
            <Link variant="subtitle2" underline="hover">
              Забыли пароль?
            </Link>
          </Stack>
          <LoadingButton
            loading={isSubmitting}
            fullWidth
            size="large"
            type="submit"
            variant="contained"
            color="inherit"
          >
            Войти
          </LoadingButton>
        </Form>
      )}
    </Formik>
  );

  return (
    <Box
      sx={{
        ...bgGradient({
          color: alpha(theme.palette.background.default, 0.9),
          imgUrl: '/assets/background/overlay_4.jpg',
        }),
        height: 1,
      }}
    >
      <Logo
        sx={{
          position: 'fixed',
          top: { xs: 16, md: 24 },
          left: { xs: 16, md: 24 },
        }}
      />

      <Stack alignItems="center" justifyContent="center" sx={{ height: 1 }}>
        <Card
          sx={{
            p: 5,
            width: 1,
            maxWidth: 420,
          }}
        >
          <Typography variant="h4" textAlign="center">
            Войти в <span style={{ color: 'red' }}>Travel HUB</span>
          </Typography>

          <Divider sx={{ my: 3 }}>
            <Typography variant="body2" sx={{ color: 'text.secondary' }}>
              |
            </Typography>
          </Divider>

          {renderForm}
        </Card>
      </Stack>
    </Box>
  );
}
