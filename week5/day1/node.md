# Node and npm

### Node

Node is a JavaScript runtime environment. This just means it's an environment where we can use javascript to write scripts. The browsers are the other environments where javascript can be used. Node is used to create servers using javascript. It's becoming very popular among developers in the current years.

### Node Package Manager - NPM

Node Package Manager or npm is the default package manager for the JavaScript runtime environment Node.js. This means that it's a tool used to manage packages.

Packages are just someone else's code that we can use. With npm you can download and use those packages easily. To install a package you use `npm install <package>` where `<package>` is the name of the package. For global installations you use the `-g` option: `npm install -g <package>`.

By the way, you need internet connection when using `npm install` since npm uses internet to download and install the package.

Packages can be installed locally in your project or globally in your computer. When you create a project, you want it to be as shareable as possible. This means that the packages you might used are easily installed by whoever wants to use your project. Or whatever computer you want to install the project.

### Projects with Node and NPM

To help you manage all the dependencies, **node** uses a file to keep track of all the packages used in the project. This file is called `package.json` and it is used by npm to install locally all the dependencies listed there.

The locally installed packages are in a folder called `node_modules/` at the same folder as the `package.json`. To add the package you just installed to `package.json` you have to use `--save` when installing it: `npm install --save <package>`.

If you download a project with a `package.json` file, you can just run `npm install` and all the dependencies will be automatically installed.

So much text... and new concepts. Let's see them in action.

1. Create a folder and navigate to it with the terminal
2. Run `npm init -y` in the terminal. This creates the `package.json` in the folder. Go take a look at it.
3. Run `npm install --save asciify`. This created the `node_modules` folder and if you take a look at `package.json` in the `dependencies` key you will see `asciify`.
4. Create a file `main.js` and add this inside
  ```javascript
  var asciify = require('asciify'); // this is how we can import external modules

  asciify('Awesome', function(err, res){ console.log(res) });
  ```
5. Execute the file from the terminal: `node main.js`

Cool! You just created your first node application.

Let's review the new commands and concepts:

- `npm init` to initialize a project
- `npm install <package>` to install a package.
- `npm install -g <package>` to globally install a package.
- `package.json` is the file with the list of dependencies.
- `npm install --save <package>` to add the dependency to `package.json`.

**Pro Tip**

When creating a repo for your `node` project. You usually add the `node_modules` folder to `.gitignore` because you don't want to add all those packages to your repo. You can always install them back with just `npm install`.

### Node Modules

Node modules also means splitting your code into different files. Each file can be considered a different module that is required and used in another one.

For example, let's suppose we have a function that calculates the area of an apartment in a file and we want to use that in one or more other files.

In order to use the module we need to first export it from the file, and them import it where we want to use it.

**Export**

In the file where we define the function that calculates the area, we need to export it.

Once the function is defined, we can exported with `module.exports`. Usually `module.exports` is an object with all the functions and/or variables you want to export from that file.

The value of `module.exports` will be the exported value when importing it from the other file.

For example:

```javascript
function calculateArea(apartment) {
  // ...
}

module.exports.calculateArea = calculateArea;
/*
Same as:
module.exports = {
  calculateArea: calculateArea
}
// also
module.exports.calculateArea = function(apartment) {
  // ...
}
*/
```

**Import**

Now, wherever we want to use the function, we first need to import it. Then we can use it.

```javascript
var myModule = require('./filename.js');

// ...
var firstArea = myModule.calculateArea(firstApartment);
```

When importing from your own file, you need to give the relative path. Hence `./filename.js`. If the file was in a folder called `helpers`, it would have been `./helpers/filename.js`.

**Importing npm packages**

If you are using an npm package the you installed via npm. Then you just use the package name.

```javascript
var asciify = require('asciify');
```

To know how to use a library you usually go to the github page of the library.

**Pro tip**

Files can be anywhere in the folder structure. Remember that you can go up in the tree with `../`.
