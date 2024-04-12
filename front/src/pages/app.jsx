import { Typography } from '@mui/material';
import { useEffect } from 'react';
import { Helmet } from 'react-helmet-async';
import { useNavigate } from 'react-router-dom';
import { AppView } from 'src/sections/overview/view';
import UserStore from 'src/store/UserStore';

// ----------------------------------------------------------------------

const AppPage = () => {
  const navigate = useNavigate();
  const { isAuth } = UserStore;

  useEffect(() => {
    if(!isAuth) navigate("/login");
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