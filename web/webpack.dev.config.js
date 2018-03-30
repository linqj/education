const HOST = process.env.HOST || '127.0.0.1';
const PORT = process.env.PORT || '3005';
const ENV = process.env.NODE_ENV || 'development';
const config = require('./config/config.json');

const webpack = require('webpack');
const path = require('path');
const fs = require('fs');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const CopyWebpackPlugin = require('copy-webpack-plugin');
const LessToJs = require('less-vars-to-js');
const antd_theme = LessToJs(fs.readFileSync(path.join(__dirname, './assets/antd_theme.less'), 'utf-8'));
// const apiAddress = process.env.API_ADDRESS || config[ENV].api;
const title = config[ENV].systemName || '';

module.exports = {
  entry: './assets/index.jsx',
  output: {
    path: path.resolve(__dirname, 'public'),
    filename: 'app.js',
    publicPath: '/'
  },
  resolve: {
    extensions: ['.js', '.json', '.jsx', '.html'],
    modules: [path.resolve(__dirname, 'node_modules'), path.resolve(__dirname, 'assets')]
  },
  devtool: 'inline-source-map',
  module: {
    rules: [
      {
        test: /\.jsx?$/,
        include: [
          path.resolve(__dirname, 'assets')
        ],
        exclude: /node_modules/,
        use: [
          {
            loader: 'react-hot-loader'
          }, {
            loader: 'babel-loader',
            options: {
              presets: ['env', 'react', 'stage-0'],
              plugins: [
                'transform-decorators-legacy',
                ['import', {'style': true, 'libraryName': 'antd'}]
              ]
            }
          }
        ]

      }, {
        test: /\.css|.less/,
        use: [{
          loader: 'style-loader'
        }, {
          loader: 'css-loader'
        }, {
          loader: 'less-loader',
          query: `{"modifyVars":${JSON.stringify(antd_theme)}}`
        }]
      }, {
        test: /\.(jpg|png)$/,
        loader: 'url-loader',
        options: {
          limit: 8192
        }
      }
    ]
  },
  plugins: [
    new HtmlWebpackPlugin({
      template: './assets/index.html',
      favicon: './assets/favicon.ico',
      inject: true,
      title: title
    }),
    new CopyWebpackPlugin([
      { from: './assets/fonts', to: 'fonts' }
    ]),
    new webpack.optimize.ModuleConcatenationPlugin()
  ],
  devServer: {
    contentBase: './public',
    hot: true,
    noInfo: true,
    inline: true,
    historyApiFallback: true,
    host: HOST,
    port: PORT,
    // proxy: {
    //   '/api': {
    //     target: apiAddress,
    //     changeOrigin: true,
    //     secure: false
    //   }
    // }
  }
};
