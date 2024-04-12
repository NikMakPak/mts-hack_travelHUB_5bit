import PropTypes from 'prop-types';
import { faker } from '@faker-js/faker';

import Box from '@mui/material/Box';
import Link from '@mui/material/Link';
import Card from '@mui/material/Card';
import Stack from '@mui/material/Stack';
import Button from '@mui/material/Button';
import Divider from '@mui/material/Divider';
import Typography from '@mui/material/Typography';
import CardHeader from '@mui/material/CardHeader';

import { fToNow } from 'src/utils/format-time';

import Iconify from 'src/components/iconify';
import Scrollbar from 'src/components/scrollbar';
import { useEffect, useState } from 'react';
import { Grid, Paper } from '@mui/material';
import AppOrderTimeline from './app-order-timeline';

// ----------------------------------------------------------------------

export default function AppNewsUpdate({ title, subheader, list, ...other }) {
  const [activeTrip, setActiveTrip] = useState(null);

  return (
    <Grid container spacing={1} wrap="nowrap" gap={3}>
      <Grid xs={5.5}>
        <Card>
          <CardHeader title={title} subheader={subheader} sx={{ mb: '15px' }} />

          <Scrollbar>
            <Stack>
              {list.map((currentBid) => (
                <NewsItem
                  key={currentBid.id}
                  currentBid={currentBid}
                  setActiveTrip={setActiveTrip}
                />
              ))}
            </Stack>
          </Scrollbar>

          <Divider sx={{ borderStyle: 'dashed' }} />

          <Box sx={{ p: 2, textAlign: 'right' }}>
            <Button
              size="small"
              color="inherit"
              endIcon={<Iconify icon="eva:arrow-ios-forward-fill" />}
            >
              Раскрыть список
            </Button>
          </Box>
        </Card>
      </Grid>
      {activeTrip && (
        <Grid sx={{ width: '100%' }}>
          <Card sx={{ p: '20px', '& > *': { mb: 2 } }}>
            <CardHeader
              title={`Информация о заявке ${activeTrip}`}
              subheader={'Ждет решения'}
              sx={{ mb: '15px', p: '0' }}
            />

            <Stack
              spacing={1}
              maxWidth={'400px'}
              direction="row"
              divider={<Divider orientation="vertical" flexItem />}
              useFlexGap
              flexWrap="wrap"
            >
              <Paper>
                <Typography variant="body2" sx={{ color: 'text.primary' }} noWrap>
                  Иван иванович иванович
                </Typography>
              </Paper>
              <Paper>
                <Typography variant="body2" sx={{ color: 'text.primary' }} noWrap>
                  Отдел
                </Typography>
              </Paper>
              <Paper>
                <Typography variant="body2" sx={{ color: 'text.primary' }} noWrap>
                  Старший сотрудник
                </Typography>
              </Paper>
              <Paper>
                <Typography variant="body2" sx={{ color: 'text.primary' }} noWrap>
                  Москва
                </Typography>
              </Paper>
              <Paper>
                <Typography variant="body2" sx={{ color: 'text.primary' }} noWrap>
                  14.01.2025 - 16.01.2025
                </Typography>
              </Paper>
            </Stack>
            <Divider sx={{ borderStyle: 'dashed' }} />
            <Box>
              <Typography variant="body2" sx={{ color: 'text.secondary', mb: 1 }} noWrap>
                Цель поездки
              </Typography>
              <Typography variant="body2" sx={{ color: 'text.primary' }} noWrap>
                Хочу работать и пить коктейли, загорать и зарабатывать деньги!
              </Typography>
            </Box>
            <Divider sx={{ borderStyle: 'dashed', mb: 0 }} />

            <AppOrderTimeline
              title="Статус заявки №123"
              list={[...Array(5)].map((_, index) => ({
                id: faker.string.uuid(),
                title: [
                  'Заявка создана',
                  'Одобрена руководителем',
                  'Одобрена Тревел менеджером',
                  'Одобрена бухгалтером',
                  'Подписан приказ',
                ][index],
                type: `order${index + 1}`,
                time: faker.date.past(),
              }))}
            />

            <Divider sx={{ borderStyle: 'dashed', mb: 0 }} />
            <Box>
              <Typography variant="body2" sx={{ color: 'text.secondary', mb: 1 }} noWrap>
                Бронирование и расходы
              </Typography>
              <Typography variant="body2" sx={{ color: 'text.primary' }} noWrap>
                Хочу работать и пить коктейли, загорать и зарабатывать деньги!
              </Typography>
            </Box>
            <Box>
              <Typography variant="body2" sx={{ color: 'text.secondary', mb: 1 }} noWrap>
                Комментарии
              </Typography>
              <Box>m</Box>
            </Box>
            <Box>
              <Typography variant="body2" sx={{ color: 'text.secondary', mb: 1 }} noWrap>
                Прикрепленные документы
              </Typography>
              <Link>Приказ</Link>
              <Button size="small" color="inherit" startIcon={<Iconify icon="ic:baseline-plus" />}>
                Прикрепить документы
              </Button>
            </Box>
            <Box sx={{ textAlign: 'left' }} spa>
              <Button variant="contained" sx={{mr:3}} color="success">
                Одобрить заявку
              </Button>
              <Button variant="contained" color="error">
                Отказать
              </Button>
            </Box>
          </Card>
        </Grid>
      )}
    </Grid>
  );
}

AppNewsUpdate.propTypes = {
  title: PropTypes.string,
  subheader: PropTypes.string,
  list: PropTypes.array.isRequired,
};

// ----------------------------------------------------------------------

function NewsItem({ currentBid, setActiveTrip }) {
  const { image, title, description, status,dates, id } = currentBid;

  return (
    <Box
      onClick={() => setActiveTrip(id)}
      alignItems="center"
      sx={{
        display: 'flex',
        p: '10px',
        gap: '10px',
        '&:hover': {
          backgroundColor: 'lightblue',
        },
      }}
    >
      <Box
        component="img"
        alt={title}
        src={image}
        sx={{ width: 48, height: 48, borderRadius: 1.5, flexShrink: 0 }}
      />

      <Box sx={{ minWidth: 240, flexGrow: 1, cursor: 'pointer' }}>
        <Typography sx={{ color: 'text.primary' }} noWrap>
          {`#${id} ${title} ${description}`}
        </Typography>
        <Typography variant="body2" sx={{ color: 'text.secondary' }} noWrap>
          {dates}
        </Typography>
      </Box>

      <Typography variant="caption" sx={{ pr: 3, flexShrink: 0, color: 'text.secondary' }}>
        {status.title}
      </Typography>
    </Box>
  );
}

NewsItem.propTypes = {
  currentBid: PropTypes.shape({
    image: PropTypes.string,
    title: PropTypes.string,
    description: PropTypes.string,
    status: PropTypes.bool,
  }),
};
