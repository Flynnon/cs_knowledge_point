var assert = require("assert");
let maxArea = require("../normal/14-191003-maxArea");
describe("test-14", function (){
    describe("测试第十四题", function (){
        it("代码正确，返回49", function (){
            assert.equal(49, maxArea([1, 8, 6, 2, 5, 4, 8, 3, 7]));
        });
        it("代码正确，返回1", function (){
            assert.equal(1, maxArea([1, 8]));
        });
        it("如果输入的数组长度小于2，返回0", function (){
            assert.equal(0, maxArea([1]));
        });
    });
});
