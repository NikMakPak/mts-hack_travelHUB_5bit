import { useState } from 'react';
import { faker } from '@faker-js/faker';

import Container from '@mui/material/Container';
import Grid from '@mui/material/Unstable_Grid2';
import Typography from '@mui/material/Typography';

import Iconify from 'src/components/iconify';

import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import { FormControl, FormLabel } from '@mui/material';
import ProductCartWidget from '../product-cart-widget';
import AppNewsUpdate from 'src/sections/overview/app-news-update';

// ----------------------------------------------------------------------

export default function ProductsView() {
  const [openFilter, setOpenFilter] = useState(false);

  const handleOpenFilter = () => {
    setOpenFilter(true);
  };

  const handleCloseFilter = () => {
    setOpenFilter(false);
  };

  return (
    <Container>
      <Typography variant="h4" sx={{ mb: 5 }}>
        Мои заявки
      </Typography>

      <AppNewsUpdate
        title="Заявки сотрудников"
        list={[...Array(5)].map((_, index) => ({
          id: faker.string.uuid(),
          title: faker.person.jobTitle(),
          description: faker.commerce.productDescription(),
          image: `/assets/images/covers/cover_${index + 1}.jpg`,
          status: 'Ждет решения',
        }))}
      />
    </Container>
  );
}
