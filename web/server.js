/* eslint-disable no-console */
const express = require('express');
const app = express();
const path = require('path');
const PORT = process.env.PORT || 3003;
// const ENV = process.env.NODE_ENV || 'production';
const STATIC_PATH = 'public';
// const proxy = require('http-proxy-middleware');
// const config = require('./config/config.json');
// const apiAddress = process.env.API_ADDRESS || config[ENV].api;

// proxy for es
// app.use('/api', proxy({
//   target: apiAddress,
//   changeOrigin: true
// }));

// serve static
app.use(express.static(path.resolve(__dirname, '.', STATIC_PATH)));

// default to spa index
app.get('*', (req, res) => {
  res.sendFile(path.resolve(__dirname, STATIC_PATH, 'index.html'));
});


app.listen(PORT, () => {
  console.log(`App start listening on port ${PORT}`);
});
