<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<!doctype html>
<html>
<head>
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type"/>
    <title>特权商城</title>
    <link rel="stylesheet" type="text/css" href="/static/styles/reset.css"/>
    <link rel="stylesheet" type="text/css" href="/static/styles/main.css"/>
    <link rel="stylesheet" type="text/css" href="/static/styles/jquery-ui.css"/>
    <script src="/static/scripts/jquery.js"></script>
    <script src="/static/scripts/funcs.js"></script>
    <script src="/static/scripts/easySlider.js"></script>
    <script src="/static/scripts/jquery.pngFix.js"></script>
    <script src="/static/scripts/jquery-ui-dialog.js"></script>
    <script>
        var gConfig = {
            siteUrl: '${siteUrl}',
            shopId: 1,
            isLogin:${isLogin},
            gameId: 78,
            displayPhone: "<c:if test="${isLogin eq true}">${loginUserInfo.displayPhone}</c:if>",
            phone: "<c:if test="${isLogin eq true}">${loginUserInfo.phone}</c:if>",
            currentPTAccount: <c:if test="${currentPTAccount ne null}">"${currentPTAccount}"</c:if><c:if test="${currentPTAccount eq null}">null</c:if>
        };
        var kvSliderList = [
            {
                "img": "${siteUrl}/static/images/4.png",
                "txt": "图片4",
                "link": "#4"
            },
            {
                "img": "${siteUrl}/static/images/1.png",
                "txt": "图片1",
                "link": "#1"
            },
            {
                "img": "${siteUrl}/static/images/2.png",
                "txt": "图片2",
                "link": "#2"
            },
            {
                "img": "${siteUrl}/static/images/3.png",
                "txt": "图片3",
                "link": "#3"
            },
            {
                "img": "${siteUrl}/static/images/5.png",
                "txt": "图片5",
                "link": "#5"
            }

        ];
    </script>
    <script src="/static/scripts/cart.js"></script>
    <script src="/static/scripts/prolist.js"></script>
    <script src="/static/scripts/main.js"></script>
</head>
<body>
<div id="loginWrap" title="用户登录">登录框</div>
<div id="selPtAccWrap" title="选择游戏帐号"></div>
<div class="warp">
<%@include file="header.jsp" %>
<div class="kvWrap">
    <div class="kvSlider">
        <div class="kvSliderView">
            <div class="kvSliderV_p">
                <div class="kvSliderText">轮播广告</div>
                <img src="${siteUrl}/static/images/4.png"/>
            </div>
        </div>
        <div class="kvSliderBlist">
            <!--<span class="kvSliderPrev" id="kvSliderPrev">上一个</span>
            <span class="kvSliderNext" id="kvSliderNext">下一个</span>-->
            <div class="kvSControl" id="kvSliderCtl">
                <ul>
                    <li><img src="${siteUrl}/static/images/thumb_1.jpg"/></li>
                    <li><img src="${siteUrl}/static/images/thumb_2.jpg"/></li>
                    <li><img src="${siteUrl}/static/images/thumb_3.jpg"/></li>
                    <li><img src="${siteUrl}/static/images/thumb_4.jpg"/></li>
                    <li><img src="${siteUrl}/static/images/thumb_5.jpg"/></li>
                </ul>
            </div>
        </div>
    </div>
    <div class="userWrap">
        <div class="weiboWrap">
            <a href="http://e.weibo.com/u/2764035304" target="_blank" class="linkWeibo"><img
                    src="http://static.sdg-china.com/ma/pic/gshop/img_btn_weibo.jpg"/></a>
            <a href="http://t.qq.com/snda_anquan" target="_blank" class="linkTWeibo"><img
                    src="http://static.sdg-china.com/ma/pic/gshop/img_btn_tweibo.jpg"/></a>
        </div>
        <div class="userBox">
            <c:if test="${isLogin eq true}">
                <div>
                    <div class="ub_avatar"><img src="http://static.sdg-china.com/ma/pic/gshop/img_avatar.jpg"/></div>
                    <div class="ub_mobile">手机：<span>${loginUserInfo.displayPhone}</span></div>
                    <div class="ub_mobile">账号：<span title="${currentPTAccount}">${currentPTAccount}</span><br/>
                        　　　[<span id="setPtAccBtn">切换帐号</span>]
                    </div>
                    <div class="ub_gcoin">：<span>${ptAccountRemain}</span></div>
                    <div class="ub_blist">
                        <a href="/order/history/1"><img src="http://static.sdg-china.com/ma/pic/gshop/img_myorder.jpg"/></a>
                        <a href="#"><img src="http://static.sdg-china.com/ma/pic/gshop/img_getgcoin.jpg"/></a>
                    </div>
                </div>
            </c:if>
            <c:if test="${isLogin eq false}">
                <div>
                    <div class="ub_loginbtn">
                        <a href="#"><img src="http://static.sdg-china.com/ma/pic/gshop/btn_login.jpg"/></a>
                    </div>
                </div>
            </c:if>
        </div>
    </div>
</div>
<div class="pageContent">
<div class="leftCon">
    <div class="prgGetGCoin">
        <div class="prgImg"><img src="http://static.sdg-china.com/ma/pic/gshop/img_process.jpg"/></div>
        <div class="prgImgGetPass"><img src="http://static.sdg-china.com/ma/pic/gshop/img_installpass.jpg"/></div>
        <div class="prgImgGetGCoin"><a href="#"><img
                src="http://static.sdg-china.com/ma/pic/gshop/img_btn_getgcoin.jpg"/></a></div>
    </div>
    <div class="mainProList" id="pListSecKill">
        <div class="pListTop">
            <h3><img src="http://static.sdg-china.com/ma/pic/gshop/t_hprice.jpg"/></h3>

            <div class="pListSKRemain"><!--距离开始还有<span class="t">10小时10分10秒</span>--></div>
            <div class="pListT_rf"><a href="#">刷新有惊喜</a></div>
        </div>
        <div class="pListSorts">
            <ul>
                <li>排序</li>
                <li class="psort">价格</li>
                <li class="psort">名称</li>
            </ul>
        </div>
        <div class="pListMain">
            <!--
            <div class="pl-bk">
                <div class="pl-img">
                    <span class="pl-imgtip pl-imgtip-onsale"></span>
                    <img src="http://static.sdg-china.com/ma/pic/gshop/tmp_pro.jpg"/>
                </div>
                <div class="pl-infbox">
                    <div class="pl-title">帅气海军帽子</div>
                    <div class="pl-prize-o">原价 <span class="pl-onum">1000</span> 点券</div>
                    <div class="pl-prize-n">现价 <span class="pl-num">100G</span> 币</div>
                    <div class="pl-btn-get"><a href="#" class="pl-btn-get-on">购买</a></div>
                </div>
            </div>
            <div class="pl-bk">
                <div class="pl-img">
                    <span class="pl-imgtip pl-imgtip-onsale"></span>
                    <img src="http://static.sdg-china.com/ma/pic/gshop/tmp_pro.jpg"/>
                </div>
                <div class="pl-infbox">
                    <div class="pl-title">帅气海军帽子</div>
                    <div class="pl-prize-o">原价 <span class="pl-onum">1000</span> 点券</div>
                    <div class="pl-prize-n">现价 <span class="pl-num">100G</span> 币</div>
                    <div class="pl-btn-get"><a href="#" class="pl-btn-get-off">购买</a></div>
                </div>
            </div>-->
        </div>
        <div class="clear"></div>
    </div>

    <div class="mainProList" id="pListExchange">
        <div class="pListTop">
            <h3><img src="http://static.sdg-china.com/ma/pic/gshop/t_gcr.jpg"/></h3>
        </div>
        <div class="pListSorts">
            <ul>
                <li>排序</li>
                <li class="psort">价格</li>
                <li class="psort">名称</li>
            </ul>
        </div>
        <div class="pListMain">
            <!--
            <div class="pl-bk">
                <div class="pl-img">
                    <span class="pl-imgtip pl-imgtip-onsale"></span>
                    <img src="http://static.sdg-china.com/ma/pic/gshop/tmp_pro.jpg"/>
                </div>
                <div class="pl-infbox">
                    <div class="pl-title">帅气海军帽子</div>
                    <div class="pl-prize-o">原价 <span class="pl-onum">1000</span> 点券</div>
                    <div class="pl-prize-n">现价 <span class="pl-num">100G</span> 币</div>
                    <div class="pl-btn-get"><a href="#" class="pl-btn-get-on">购买</a></div>
                </div>
            </div>
            <div class="pl-bk">
                <div class="pl-img">
                    <span class="pl-imgtip pl-imgtip-onsale"></span>
                    <img src="http://static.sdg-china.com/ma/pic/gshop/tmp_pro.jpg"/>
                </div>
                <div class="pl-infbox">
                    <div class="pl-title">帅气海军帽子</div>
                    <div class="pl-prize-o">原价 <span class="pl-onum">1000</span> 点券</div>
                    <div class="pl-prize-n">现价 <span class="pl-num">100G</span> 币</div>
                    <div class="pl-btn-get"><a href="#" class="pl-btn-get-off">购买</a></div>
                </div>
            </div>-->
        </div>
        <div class="clear"></div>
        <div class="pListPg">
            <a href="#" class="pl-pg-prev">上一页</a>
            <a href="#" class="pl-pg-next">下一页</a>
            <center>
                <table>
                    <tr>
                        <!--<td><a href="#">1</a></td>
                        <td><a href="#" class="cur">2</a></td>
                        <td><a href="#">3</a></td>
                        <td><a href="#">4</a></td>-->
                    </tr>
                </table>
            </center>
        </div>
    </div>
</div>
<div class="rightCon">
    <div class="topGList">
        <div class="leftTitle">
            <img src="http://static.sdg-china.com/ma/pic/gshop/t_topfive.jpg"/>
        </div>
        <ul>
            <li class="tgl-l1">
                <div class="tgl-img"><img src="http://static.sdg-china.com/ma/pic/gshop/tmp_g_l.jpg"/></div>
                <div class="tgl-title">零世界</div>
                <div class="tgl-desc">修改昵称 使用道具…</div>
            </li>
            <li class="tgl-l2">
                <div class="tgl-img"><img src="http://static.sdg-china.com/ma/pic/gshop/tmp_g_l.jpg"/></div>
                <div class="tgl-title">零世界</div>
                <div class="tgl-desc">修改昵称 使用道具…</div>
            </li>
            <li class="tgl-l3">
                <div class="tgl-img"><img src="http://static.sdg-china.com/ma/pic/gshop/tmp_g_l.jpg"/></div>
                <div class="tgl-title">零世界</div>
                <div class="tgl-desc">修改昵称 使用道具…</div>
            </li>
            <li class="tgl-l4">
                <div class="tgl-img"><img src="http://static.sdg-china.com/ma/pic/gshop/tmp_g_l.jpg"/></div>
                <div class="tgl-title">零世界</div>
                <div class="tgl-desc">修改昵称 使用道具…</div>
            </li>
            <li class="tgl-l5">
                <div class="tgl-img"><img src="http://static.sdg-china.com/ma/pic/gshop/tmp_g_l.jpg"/></div>
                <div class="tgl-title">零世界</div>
                <div class="tgl-desc">修改昵称 使用道具…</div>
            </li>
            <li class="tgl-l6">
                <div class="tgl-img"><img src="http://static.sdg-china.com/ma/pic/gshop/tmp_g_l.jpg"/></div>
                <div class="tgl-title">零世界</div>
                <div class="tgl-desc">修改昵称 使用道具…</div>
            </li>
        </ul>
        <div class="clear"></div>
    </div>
    <div class="leftGList">
        <div class="leftTitle">
            <img src="http://static.sdg-china.com/ma/pic/gshop/t_gamelist.jpg"/>
        </div>
        <div class="lGListT">角色扮演</div>
        <ul>
            <li><a href="#"><img src="http://static.sdg-china.com/ma/pic/gshop/img_game_s.jpg"/>零世界</a></li>
            <li><a href="#"><img src="http://static.sdg-china.com/ma/pic/gshop/img_game_s.jpg"/>零世界</a></li>
            <li><a href="#"><img src="http://static.sdg-china.com/ma/pic/gshop/img_game_s.jpg"/>零世界</a></li>
            <li><a href="#"><img src="http://static.sdg-china.com/ma/pic/gshop/img_game_s.jpg"/>零世界</a></li>
            <li><a href="#"><img src="http://static.sdg-china.com/ma/pic/gshop/img_game_s.jpg"/>零世界</a></li>
            <li><a href="#"><img src="http://static.sdg-china.com/ma/pic/gshop/img_game_s.jpg"/>零世界</a></li>
            <li><a href="#"><img src="http://static.sdg-china.com/ma/pic/gshop/img_game_s.jpg"/>零世界</a></li>
            <li><a href="#"><img src="http://static.sdg-china.com/ma/pic/gshop/img_game_s.jpg"/>零世界</a></li>
            <li><a href="#"><img src="http://static.sdg-china.com/ma/pic/gshop/img_game_s.jpg"/>零世界</a></li>
            <li><a href="#"><img src="http://static.sdg-china.com/ma/pic/gshop/img_game_s.jpg"/>零世界</a></li>
        </ul>
        <div class="clear"></div>
        <div class="lGListT">竞技游戏</div>
        <ul>
            <li><a href="#"><img src="http://static.sdg-china.com/ma/pic/gshop/img_game_s.jpg"/>零世界</a></li>
            <li><a href="#"><img src="http://static.sdg-china.com/ma/pic/gshop/img_game_s.jpg"/>零世界</a></li>
            <li><a href="#"><img src="http://static.sdg-china.com/ma/pic/gshop/img_game_s.jpg"/>零世界</a></li>
            <li><a href="#"><img src="http://static.sdg-china.com/ma/pic/gshop/img_game_s.jpg"/>零世界</a></li>
            <li><a href="#"><img src="http://static.sdg-china.com/ma/pic/gshop/img_game_s.jpg"/>零世界</a></li>
            <li><a href="#"><img src="http://static.sdg-china.com/ma/pic/gshop/img_game_s.jpg"/>零世界</a></li>
            <li><a href="#"><img src="http://static.sdg-china.com/ma/pic/gshop/img_game_s.jpg"/>零世界</a></li>
            <li><a href="#"><img src="http://static.sdg-china.com/ma/pic/gshop/img_game_s.jpg"/>零世界</a></li>
            <li><a href="#"><img src="http://static.sdg-china.com/ma/pic/gshop/img_game_s.jpg"/>零世界</a></li>
            <li><a href="#"><img src="http://static.sdg-china.com/ma/pic/gshop/img_game_s.jpg"/>零世界</a></li>
        </ul>
        <div class="clear"></div>
        <div class="lGListT">网页游戏</div>
        <ul>
            <li><a href="#"><img src="http://static.sdg-china.com/ma/pic/gshop/img_game_s.jpg"/>零世界</a></li>
            <li><a href="#"><img src="http://static.sdg-china.com/ma/pic/gshop/img_game_s.jpg"/>零世界</a></li>
            <li><a href="#"><img src="http://static.sdg-china.com/ma/pic/gshop/img_game_s.jpg"/>零世界</a></li>
            <li><a href="#"><img src="http://static.sdg-china.com/ma/pic/gshop/img_game_s.jpg"/>零世界</a></li>
            <li><a href="#"><img src="http://static.sdg-china.com/ma/pic/gshop/img_game_s.jpg"/>零世界</a></li>
            <li><a href="#"><img src="http://static.sdg-china.com/ma/pic/gshop/img_game_s.jpg"/>零世界</a></li>
            <li><a href="#"><img src="http://static.sdg-china.com/ma/pic/gshop/img_game_s.jpg"/>零世界</a></li>
            <li><a href="#"><img src="http://static.sdg-china.com/ma/pic/gshop/img_game_s.jpg"/>零世界</a></li>
            <li><a href="#"><img src="http://static.sdg-china.com/ma/pic/gshop/img_game_s.jpg"/>零世界</a></li>
            <li><a href="#"><img src="http://static.sdg-china.com/ma/pic/gshop/img_game_s.jpg"/>零世界</a></li>
        </ul>
        <div class="clear"></div>
    </div>
    <div class="lDownPass">
        <img src="http://static.sdg-china.com/ma/pic/gshop/img_downpass.jpg"/>

        <div class="ldp_qr">
            <img src="http://static.sdg-china.com/ma/pic/gshop/img_passqr.jpg"/>
        </div>
    </div>
</div>
<div class="clear"></div>
</div>
<%@include file="footer.jsp" %>
</div>
<!--<div class="mainCartView">
    <div class="cartOpened">
        <div class="cartTitle">购物车商品列表
            <a href="#" class="cartBtnClose">关闭</a>
        </div>
        <div class="cartOrderList">
            <div class="col-bk">
                <div class="col-img"><img src="http://static.sdg-china.com/ma/pic/gshop/img_protmp_l2.jpg"/></div>
                <div class="col-descbox">
                    <p>商品：帅气海军帽</p>
                    <p>单价：<span class="col-dprize">100G</span>币</p>
                </div>
                <div class="col-operatebox">
                    <div class="col-ordernum">数量：<input type="text"/></div>
                    <div class="col-orderdel"><a href="#">删除</a></div>
                </div>
            </div>
            <div class="col-bk">
                <div class="col-img"><img src="http://static.sdg-china.com/ma/pic/gshop/img_protmp_l2.jpg"/></div>
                <div class="col-descbox">
                    <p>商品：帅气海军帽</p>
                    <p>单价：<span class="col-dprize">100G</span>币</p>
                </div>
                <div class="col-operatebox">
                    <div class="col-ordernum">数量：<input type="text"/></div>
                    <div class="col-orderdel"><a href="#">删除</a></div>
                </div>
            </div>
            <div class="col-bk">
                <div class="col-img"><img src="http://static.sdg-china.com/ma/pic/gshop/img_protmp_l2.jpg"/></div>
                <div class="col-descbox">
                    <p>商品：帅气海军帽</p>
                    <p>单价：<span class="col-dprize">100G</span>币</p>
                </div>
                <div class="col-operatebox">
                    <div class="col-ordernum">数量：<input type="text"/></div>
                    <div class="col-orderdel"><a href="#">删除</a></div>
                </div>
            </div>
            <div class="col-bk">
                <div class="col-img"><img src="http://static.sdg-china.com/ma/pic/gshop/img_protmp_l2.jpg"/></div>
                <div class="col-descbox">
                    <p>商品：帅气海军帽</p>
                    <p>单价：<span class="col-dprize">100G</span>币</p>
                </div>
                <div class="col-operatebox">
                    <div class="col-ordernum">数量：<input type="text"/></div>
                    <div class="col-orderdel"><a href="#">删除</a></div>
                </div>
            </div>
            <div class="clear"></div>
        </div>
        <div class="cartGoCheck">
            <a href="#"><img src="http://static.sdg-china.com/ma/pic/gshop/btn_cart_gobalance.jpg"/></a>
        </div>
    </div>
    <div class="cartClosed" style="display:none;">
        <div class="cartInfView">
            购物车中共有<span class="cartInfPnum">2</span>件商品
        </div>
        <div class="cartOpenBtn">
            <a href="#"><img src="http://static.sdg-china.com/ma/pic/gshop/btn_viewcart.jpg"/></a>
        </div>
    </div>
</div>-->
</body>
</html>
