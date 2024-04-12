import SvgColor from 'src/components/svg-color';

// ----------------------------------------------------------------------

const icon = (name) => (
  <SvgColor src={`/assets/icons/navbar/${name}.svg`} sx={{ width: 1, height: 1 }} />
);

const navConfig = [
  {
    title: 'создать заявку',
    path: '/',
    icon: icon('ic_analytics'),
  },
  {
    title: 'мои заявки',
    path: '/products',
    icon: icon('ic_cart'),
  },
  {
    title: 'выйти',
    path: '/404',
    icon: icon('ic_disabled'),
  },
];

export default navConfig;
