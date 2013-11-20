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
            destroy: '/category/delete'
        },
        dish: {
            create: '/dish/edit',
            read: '/dish/list',
            update: '/dish/edit',
            destroy: '/dish/delete'
        },
        restaurant: {
            create: '../api/restaurant.php?action=create',
            read: '/restaurant/list',
            update: '/restaurant/edit',
            destroy: '../api/restaurant.php?action=destroy'
        }
    }
};
