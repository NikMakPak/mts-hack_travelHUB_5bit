import React from 'react';
import { TextField, Button, Typography, Box, Paper } from '@mui/material';
import { AdapterDayjs } from '@mui/x-date-pickers/AdapterDayjs';
import { LocalizationProvider } from '@mui/x-date-pickers/LocalizationProvider';
import { DatePicker } from '@mui/x-date-pickers/DatePicker';
import { useFormik } from 'formik';
import * as yup from 'yup';

const validationSchema = yup.object({
  country: yup.string().required('Поле обязательно'),
  departureDate: yup.date().required('Поле обязательно'),
  returnDate: yup.date().required('Поле обязательно'),
  purpose: yup.string().required('Поле обязательно'),
});

const CreateTripForm = () => {
  const formik = useFormik({
    initialValues: {
      country: '',
      departureDate: null,
      returnDate: null,
      purpose: '',
      additionalDocuments: null,
    },
    validationSchema: validationSchema,
    onSubmit: (values) => {
      console.log(values);
    },
  });

  return (
    <LocalizationProvider dateAdapter={AdapterDayjs}>
      <Paper elevation={5}>
        <form onSubmit={formik.handleSubmit} style={{ display: 'grid', gap: '20px', padding: '20px' }}>
          <TextField
            fullWidth
            id="country"
            name="country"
            label="Страна"
            placeholder="Страна"
            value={formik.values.country}
            onChange={formik.handleChange}
            error={formik.touched.country && Boolean(formik.errors.country)}
            helperText={formik.touched.country && formik.errors.country}
          />
          <Box sx={{ display: 'flex', gap: '20px' }}>
            <DatePicker
              sx={{ flex: 1 }}
              label="Дата выезда"
              value={formik.values.departureDate}
              onChange={(newValue) => {
                formik.setFieldValue('departureDate', newValue);
              }}
              renderInput={(params) => (
                <TextField
                  {...params}
                  fullWidth
                  error={formik.touched.departureDate && Boolean(formik.errors.departureDate)}
                  helperText={formik.touched.departureDate && formik.errors.departureDate}
                />
              )}
            />
            <DatePicker
              sx={{ flex: 1 }}
              label="Дата приезда"
              value={formik.values.returnDate}
              onChange={(newValue) => {
                formik.setFieldValue('returnDate', newValue);
              }}
              renderInput={(params) => <TextField {...params} fullWidth />}
            />
          </Box>
          <TextField
            fullWidth
            id="purpose"
            name="purpose"
            label="Цель поездки"
            placeholder="Цель поездки"
            multiline
            rows={4}
            value={formik.values.purpose}
            onChange={formik.handleChange}
            error={formik.touched.purpose && Boolean(formik.errors.purpose)}
            helperText={formik.touched.purpose && formik.errors.purpose}
          />
          <Typography variant="h6">Доп. документы</Typography>
          <input
            accept=".pdf,.doc,.docx"
            id="additionalDocuments"
            name="additionalDocuments"
            type="file"
            onChange={(event) => {
              formik.setFieldValue('additionalDocuments', event.currentTarget.files[0]);
            }}
          />
          <Button color="primary" variant="contained" fullWidth type="submit">
            Отправить на согласование
          </Button>
        </form>
      </Paper>
    </LocalizationProvider>
  );
};

export default CreateTripForm;
