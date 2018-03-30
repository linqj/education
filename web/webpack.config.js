 const path = require('path');
const fs = require('fs');
const webpack = require('webpack');
const CleanWebpackPlugin = require('clean-webpack-plugin');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const ExtractTextPlugin = require('extract-text-webpack-plugin');
const CopyWebpackPlugin = require('copy-webpack-plugin');
const LessToJs = require('less-vars-to-js');
const config = require('./config/config.json');
const ENV = process.env.NODE_ENV || 'production';
const title = config[ENV].systemName || '';

const antd_theme = LessToJs(fs.readFileSync(path.join(__dirname, './assets/antd_theme.less'), 'utf-8'));

module.exports = {
  entry: './assets/index.jsx',
  output: {
    path: path.resolve(__dirname, 'public'),
    filename: '[name].[chunkhash:8].js',
    publicPath: '/'
  },
  resolve: {
    extensions: [
      '.js', '.json', '.jsx', '.html'
    ],
    modules: [
      path.resolve(__dirname, 'node_modules'),
      path.resolve(__dirname, 'assets')
    ]
  },
  module: {
    rules: [
      {
        test: /\.jsx?$/,
        include: [path.resolve(__dirname, 'assets')],
        exclude: /node_modules/,
        use: [
          {
            loader: 'babel-loader',
            options: {
              presets: ['env', 'react', 'stage-0'],
              plugins: [
                'transform-decorators-legacy',
                [
                  'import', {
                    'style': true,
                    'libraryName': 'antd'
                  }
                ]
              ]
            }
          }
        ]

      }, {
        test: /\.css|.less/,
        use: ExtractTextPlugin.extract({
          fallback: 'style-loader',
          use: [
            {
              loader: 'css-loader'
            }, {
              loader: 'less-loader',
              query: `{"modifyVars":${JSON.stringify(antd_theme)}}`
            }
          ]
        })
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
    new CleanWebpackPlugin(['public']),
    new HtmlWebpackPlugin({
      template: './assets/index.html',
      favicon: './assets/favicon.ico',
      inject: true,
      title: title
    }),
    new webpack.optimize.UglifyJsPlugin({
      beautify: false,
      mangle: {
        screw_ie8: true,
        keep_fnames: true
      },
      compress: {
        screw_ie8: true,
        warnings: false
      },
      comments: false
    }),
    new ExtractTextPlugin('[name].[contenthash:8].css'),
    new webpack.DefinePlugin({
      'process.env': {
        NODE_ENV: JSON.stringify('production')
      }
    }),
    new webpack.optimize.CommonsChunkPlugin({
      name: 'vendor',
      minChunks: function(module) {
        return module.context && module.context.indexOf('node_modules') !== -1;
      }
    }),
    new webpack.optimize.CommonsChunkPlugin({name: 'manifest'}),
    new CopyWebpackPlugin([
      { from: './assets/fonts', to: 'fonts' }
    ]),
    new webpack.optimize.ModuleConcatenationPlugin()
  ]
};
