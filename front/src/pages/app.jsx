import { Typography } from '@mui/material';
import { useEffect } from 'react';
import { Helmet } from 'react-helmet-async';
import { useRouter } from 'src/routes/hooks';
import { AppView } from 'src/sections/overview/view';
import UserStore from 'src/store/UserStore';

// ----------------------------------------------------------------------

const AppPage = () => {
  const router = useRouter();
  const { isAuth } = UserStore;

  useEffect(() => {
    if(!isAuth) router.push('/login');
  }, [])
  
  return (
    <>
      <Helmet>
        <title> MTS Travel HUB </title>
      </Helmet>

      {isAuth ? <AppView /> : <Typography>Loading...</Typography>}
    </>
  );
}
export default AppPage;