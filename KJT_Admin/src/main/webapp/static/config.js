/**
 * Created with JetBrains PhpStorm.
 * @author ishowshao
 * @date 13-11-17
 */
var config = {
    api: {
        category: {
            create: '/category/edit', //POST {"success":true}
            read: '/category/list', //GET {"success":true,"data":[]}
            update: '/category/edit', //POST {"success":true}
            destroy: '../api/category.php?action=destroy'
        },
        dish: {
            create: '../api/dish.php?action=create',
            read: '../api/dish.php?action=read',
            update: '../api/dish.php?action=update',
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
