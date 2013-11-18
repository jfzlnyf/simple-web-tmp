/**
 * Created with JetBrains PhpStorm.
 * @author ishowshao
 * @date 13-11-17
 */
var config = {
    appFolder: '/static/app', //你改成 /static/app
    api: {
        category: {
            create: '/category/edit', //POST {"success":true}
            read: '/category/list', //GET {"success":true,"data":[]}
            update: '/category/edit', //POST {"success":true}
            destroy: '../api/category.php?action=destroy'
        },
        dish: {
            create: '/dish/edit',
            read: '/dish/list',
            update: '/dish/edit',
            destroy: '../api/dish.php?action=destroy'
        },
        restaurant: {
            create: '../api/restaurant.php?action=create',
            read: '/restaurant/list',
            update: '../api/restaurant.php?action=update',
            destroy: '../api/restaurant.php?action=destroy'
        }
    }
};
