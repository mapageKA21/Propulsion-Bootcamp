# CSS Layout

Layout is about how to position the elements in the page. There are many ways of doing it. We will cover some of the most used ones and also some of the newest ones.

### CSS Positioning

First of all, remember that each element in the page is a block of pixels with a width and a height.

Each of this blocks has a value for *how* to handle where to put himself with regards the others elements. This is the `position` rule. Then there are others rules that tell the element *where* to put themselves with regards the others.

Positioning is a rule that doesn't cascade. If the parent has a `position: absolute`, that does not mean all their children will have it.

**Static**

This is the default value.

This just means it will flow normally, according to how it's set in the html.

**Relative**

One of the most confusing ones.

It means 'relative' to itself. Just adding that doesn't change anything. Usually it goes together with other rules: `top`, `left`, `right` and `bottom`. It will shift the element on that direction from where it would have normally been.

Other two important things happen when using `relative`:

- Limits the scope of the child positioned as `absolute`.
- It allows the possibility to use `z-index`. All their children will also appear on top of the other `static` elements.

**Absolute**

One of the most powerful.

It allows you to position an element wherever you want. You can use `top`, `left`, `right` and `bottom`.

However, the limitation is that the position will be relative to the first parent with `position: relative`. Not to the whole page.

The other important thing, is that elements with `absolute` will be removed from the normal flow of elements.

**Fixed**

Last but not least.

Using fixed will position the element relative to the *viewport*.

There might be some usability concerns depending on the viewport size. So it's always important to properly test when using `fixed`.

**Simplistic Conclusions**

- `static`: default
- `relative`: relative to itself - creates a new scope
- `absolute`: relative to the next `relative` parent
- `fixed`: relative to the *viewport*

Check this nice [article](https://css-tricks.com/absolute-relative-fixed-positioining-how-do-they-differ/) for more info.

### Float

Float changes the way *block elements* are laid out by the browser. They are placed along the left or right side of its container.

*Block Elements* are those with `display: block;` by default.

By default, block elements take up 100% of their parent element. Even though the width is set to less than 100% of the parent, they will take a whole row. Blocking the following elements from moving up.

However, when using `float` or `display: inline-block`, and when there is room, the following elements will all be in the same row. Until the total exceeds the width of the parent element.

When using `float` the element is shifted until it touches the edge of its containing box or another floated element.

**Values**

- `float: left`: It places the element on the left side of the parent
- `float: right`: It places the element on the right side of the parent.

### Flexbox

Flexbox Layout is another way of positioning your elements compared to CSS Positioning techniques.

You can combine both techniques together, but not use them at the same time in the same element.

With the Flexbox Layout, the container has the ability to alter its items' width/height and order in order to fill the space.

Lastly, it is important to know that is direction-agnostic. We will see how you can easily change the direction of the items by only changing a property in the parent.

The most important thing to understand is that there are rules for the *Parent* and rules for the *children*.

To start a Flexbox Layout you set `display: flex` in the parent.

**Parent rules**

- `display: flex`
- `flex-direction`
- `flex-wrap`
- `flex-flow`. Shorthand for `flex-direction` and `flex-wrap`.
- `justify-content`
- `align-items`
- `align-content`

**Child rules**

- `order`. default is 0 for all the elements
- `flex-grow`
- `flex-shrink`
- `flex-basis`
- `flex`. Shorthand for `flex-grow`, `flex-shrink` and `flex-basis`
- `align-self`

Please, read the following [article](https://css-tricks.com/snippets/css/a-guide-to-flexbox/) for a quick explanation of each of these rules.

**Exercise**

Practice placing [frogs](http://flexboxfroggy.com/) in the pond.

### Columns Layout

This is a another way of positioning elements in a Page. It is mostly use to create a *newspaper-like* grid in the web.

It allows for a nice fluid layout that can be very responsive-friendly.

Most common example of Columns Layout is [Pinterest](https://www.pinterest.com/).

In order to start with the Columns Layout you need to set the `columns` rule to the parent element. Then the children elements will be split into columns.

**Parent**

- `columns-count`
- `columns-width`
- `columns`. Shorthand for `columns-count` and `columns-width`.
- `column-gap`
- `column-rule`. Border between columns. Shortand for `columns-rule-width`, `columns-rule-style` and `columns-rule-color`

**Children**

- `column-span`

Please read this [article](https://css-tricks.com/guide-responsive-friendly-css-columns/) for all the information

### CSS Grid Layout

This is the newest of all and not fully supported.

It allows for a lot of flexibility. Check this [article](*https://css-tricks.com/things-ive-learned-css-grid-layout/) for further information.

During this course we won't use the Grid Layout.
