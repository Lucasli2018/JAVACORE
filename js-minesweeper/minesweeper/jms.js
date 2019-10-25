//在jms.js中
(function () {
    // 初始化扫雷对象，初始化数据   
    var JMS = function (id,rowCount,colCount, minLandMineCount, maxLandMineCount) {
        if (!(this instanceof JMS))
            return new JMS(id, rowCount, colCount, minLandMineCount, maxLandMineCount);
        this.doc = document;
        this.table = this.doc.getElementById(id);//画格子的表格
        this.cells = this.table.getElementsByTagName("td");//小格子
        this.rowCount = rowCount || 10;//格子行数
        this.colCount = colCount || 10;//格子列数
        this.landMineCount = 0;//地雷个数
        this.markLandMineCount = 0;//标记的地雷个数
        this.minLandMineCount = minLandMineCount || 10;//地雷最少个数
        this.maxLandMineCount = maxLandMineCount || 20;//地雷最多个数
        this.arrs = [];//格子对应的数组
        this.beginTime = null;//游戏开始时间
        this.endTime = null;//游戏结束时间
        this.currentSetpCount = 0;//当前走的步数
        this.endCallBack = null;//游戏结束时的回调函数
        this.landMineCallBack = null;//标记为地雷时更新剩余地雷个数的回调函数
        this.doc.oncontextmenu = function () {//禁用右键菜单
            return false;
        };
        this.drawMap();
    };

    // 在 JMS 的原型中创建格子
    JMS.prototype = {
        //画格子
        drawMap: function () {
            var tds = [];
            // 为了兼容浏览器
            if (window.ActiveXObject && parseInt(navigator.userAgent.match(/msie ([\d.]+)/i)[1]) < 8) {
                // 创建引入新的 css 样式文件
                var css = '#JMS_main table td{background-color:#888;}',
                    // 获取 head 标签
                    head = this.doc.getElementsByTagName("head")[0],
                    // 创建 style 标签
                    style = this.doc.createElement("style");
                    style.type = "text/css";
                if (style.styleSheet) {
                    // 将 css 样式赋给 style 标签
                    style.styleSheet.cssText = css;
                } else {
                    // 在 style 标签中创建节点
                    style.appendChild(this.doc.createTextNode(css));
                }
                // 再将 style 标签创建为 head 标签的子标签
                head.appendChild(style);
            }
            // 循环创建表格
            for (var i = 0; i < this.rowCount; i++) {
                tds.push("<tr>");
                for (var j = 0; j < this.colCount; j++) {
                    tds.push("<td id='m_" + i + "_" + j + "'></td>");
                }
                tds.push("</tr>");
            }
            this.setTableInnerHTML(this.table, tds.join(""));
        },
        //添加HTML到Table
        setTableInnerHTML: function (table, html) {
            if (navigator && navigator.userAgent.match(/msie/i)) {
                // 在 table 的 owner document 内创建 div
                var temp = table.ownerDocument.createElement('div');
                // 创建表格的 tbody 内容
                temp.innerHTML = '<table><tbody>' + html + '</tbody></table>';
                if (table.tBodies.length == 0) {
                    var tbody = document.createElement("tbody");
                    table.appendChild(tbody);
                }
                table.replaceChild(temp.firstChild.firstChild, table.tBodies[0]);
            } else {
                table.innerHTML = html;
            }
        }
    };

    window.JMS = JMS;
})();