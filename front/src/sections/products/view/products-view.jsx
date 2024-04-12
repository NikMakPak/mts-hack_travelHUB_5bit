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

const bids = [
  {
    id: '123',
    title: 'Великий Новгород',
    description: 'Яков А.П.',
    image: `/assets/images/covers/cover_${1}.jpg`,
    dates: '14.07.2024 - 19.07.2024',
    status: {
      code: 1,
      title: 'Ждет решения',
    },
  },
  {
    id: '074',
    title: 'Москва',
    description: 'Яков А.П.',
    image: `/assets/images/covers/cover_${1}.jpg`,
    dates: '14.07.2024 - 19.07.2024',
    status: {
      code: 1,
      title: 'Создана',
    },
  },
  {
    id: '543',
    title: 'Рязань',
    description: 'Яков А.П.',
    image: `/assets/images/covers/cover_${1}.jpg`,
    dates: '14.07.2024 - 19.07.2024',
    status: {
      code: 1,
      title: 'Одобрена',
    },
  },
  {
    id: '345',
    title: 'Великий Новгород',
    description: 'Яков А.П.',
    image: `/assets/images/covers/cover_${1}.jpg`,
    dates: '14.07.2024 - 19.07.2024',
    status: {
      code: 1,
      title: 'Отказано',
    },
  },
];

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

      <AppNewsUpdate title="Заявки сотрудников" list={bids} />
    </Container>
  );
}
