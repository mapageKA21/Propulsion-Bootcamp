module.exports = {
  entry: __dirname + '/src/app.js',
  output: {
    path: __dirname + '/build/',
    publicPath: '/build/',
    filename: 'app.bundle.js'
  },
  module: {
    loaders: [
      {
        test: /\.js$/,
        exclude: /(node_modules)/,
        loader: 'babel-loader',
        query: {
          presets: ['es2015']
        }
      },
      {
        test: /\.css$/,
        exclude: /(node_modules)/,
        loaders: ['style', 'css']
      },
      {
        test: /\.jpg/,
        exclude: /(node_modules)/,
        loader: 'url'
      }
    ]
  },
}
