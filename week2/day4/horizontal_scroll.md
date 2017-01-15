# Horizontal scroll

By Horizontal Scroll we mean an horizontal list of items where you can look for more items clicking in the arrows and all the items are scrolled to one side of the page. Check [Netflix](www.netflix.com) or [Wuaki](www.wuaki.tv) as examples.

Creating an horizontal scroll is tricky and there are plenty of ways to do it. Here we will introduce a technique that is widely used.

In order to create an horizontal scroll we need to make html, css and Javascript work together.

Similar technique can be applied for the main slider. Although we won't cover that here.

**PRO TIP:** For placeholders check http://placebeyonce.com and http://placekitten.com.

### Horizontal List

Create a folder with an HTML, CSS and JS files. Add jQuery.

First you should try to get an horizontal list of items that is scrollable without arrows.

```HTML
<div class="wrapper">
  <div class="horizontal-scroll">
    <div class="item"></div>
    <div class="item"></div>
    <div class="item"></div>
    <div class="item"></div>
    <div class="item"></div>
    <div class="item"></div>
    <div class="item"></div>
    <div class="item"></div>
    <div class="item"></div>
  </div>
</div>
```

The `.wrapper` should have `overflow: hidden` and `white-space: nowrap`. Each of the items need to have either a `float` property or `inline-block`.

For now create that you should have 4 items in the page at the same time.

If you have horizontal scroll pad in your laptop you should be able to scroll horizontally from the beginning to the end of the list.

### Animation

Now we need to understand how to animate.

Check how `transition` and `transform` works in [CSS Reference](http://cssreference.io/).

We will use the `transition` rule together with the `transform`. The idea is that the `.horizontal-scroll` block, will move from the original position. So that the items shown in the `.wrapper` are different.

First of all, try adding this CSS:

```css
.horizontal-scroll {
  transition: all 1s ease;
}
```

Now once you are in the html, change the `transform: translateX(300px)` manually to the `.horizontal-scroll` element from Chrome Dev Tools. You should be able to see your first transition.

### User interaction

Good, now we want that animation when the user clicks in the arrows.

In order to do that, first add a left arrow and a right arrow. They should be outside of the `.wrapper`.

Add a handler to the `click` event on each arrow.

In the handler, you should focus on two different things.

- Get the current horizontal position of the `.horizontal-scroll`. Investigate the `.position()` method on jQuery to help you with that.
- Change the `.horizontal-scroll` `transform` property with Javascript accordingly. If you are moving to the left, it should subtract from the current position, if moving to the right, it should add.

**TIP: It is ok to have negative values in `translateX`**

**Ask for a review from your instructor**
