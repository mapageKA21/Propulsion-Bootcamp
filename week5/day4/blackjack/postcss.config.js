var autoprefixer = require('autoprefixer');
var ifMedia = require('postcss-if-media');

module.exports = {
  plugins: [
    autoprefixer({ /* ...options */ }),
    ifMedia(),
  ],
};
