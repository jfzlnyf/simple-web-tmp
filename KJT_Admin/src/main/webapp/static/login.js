/**
 * Created with JetBrains PhpStorm.
 * @author ishowshao
 * @date 13-11-18
 */
Ext.application({
    name: 'Admin',
    appFolder: 'app',
    launch: function () {
        console.log('Application launch');

        Ext.create('Ext.window.Window', {
            title: 'Please login',
            items: [
                {
                    xtype: 'form',
                    url: '/login',
                    standardSubmit: true,
                    border: false,
                    bodyPadding: '10 10 10 10',
                    items: [
                        {
                            xtype: 'textfield',
                            fieldLabel: 'Username',
                            labelWidth: 60,
                            name: 'username'
                        },
                        {
                            xtype: 'textfield',
                            fieldLabel: 'Password',
                            inputType: 'password',
                            labelWidth: 60,
                            name: 'password'
                        }
                    ]
                }
            ],
            buttons: [
                {
                    text: 'Login',
                    handler: function () {
                        Ext.ComponentQuery.query('form')[0].submit();
                    }
                }
            ]
        }).show();
    }
});
