/**
 * Created with JetBrains PhpStorm.
 * @author ishowshao
 * @date 13-10-31
 */
Ext.application({
    name: 'Admin',
    appFolder: config.appFolder,
    controllers: [
        'Menu', 'Category', 'Dish', 'Restaurant'
    ],
    launch: function () {
        console.log('Application launch');

        Ext.create('Ext.container.Viewport', {
            layout: 'border',
            listeners: {
                render: function () {
                    console.log('render');
                }
            },
            items: [
                {
                    xtype: 'container',
                    region: 'north',     // position for region
                    height: 40,
                    html: '<div style="line-height: 40px; font-size: 24px; padding-left: 15px;">Admin<span id="login-info" style="font-size: 12px;"></span></div>'
                },
                {
                    xtype: 'Admin-menu'
                },
                {
                    xtype: 'container',
                    itemId: 'center',
                    region: 'center',     // center region is required, no width/height specified
                    layout: 'fit',
                    items: [
                        {
                            xtype: 'category',
                            hidden: true
                        },
                        {
                            xtype: 'dish',
                            hidden: true
                        },
                        {
                            xtype: 'restaurant',
                            hidden: false
                        }
                    ]
                }
            ]
        });
    }
});
