module.exports = {
  entry: __dirname + '/src/app.js',
  output: {
    path: __dirname + '/build/',
    publicPath: '/build/', // for webpack-dev-server
    filename: 'app.bundle.js',
  },
  module: {
    loaders: [
      {
        test: /\.js$/,
        exclude: /(node_modules)/,
        loader: 'babel-loader',
        query: {
          presets: ['es2015'],
        },
      },
      {
        test: /\.css$/,
        exclude: /(node_modules)/,
        loaders: ['style', 'css-loader?modules&importLoaders=1&localIdentName=[name]__[local]___[hash:base64:5]', 'postcss-loader']
        // loader: 'style!css-loader?modules&importLoaders=1&localIdentName=[name]__[local]___[hash:base64:5]!postcss-loader',
      },
      {
        test: /\.jpg/,
        exclude: /(node_modules)/,
        loader: 'url',
      },
    ],
  },
};
