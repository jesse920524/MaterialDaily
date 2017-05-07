package androiddeveloper.the.jessefu.mvpactualcombat.model.guokrNews;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Jesse Fu on 2017-04-29.
 * 果壳精选列表页
 */

public class GuokrNewsBean {

    /**
     * now : 2017-04-29T20:43:16.527129+08:00
     * ok : true
     * result : [{"link_v2_sync_img":"http://jingxuan.guokr.com/pick/v2/82897/sync/","source_name":"天了噜！","video_url":"","current_user_has_collected":false,"likings_count":7,"images":["http://1.im.guokr.com/eZob3HShd7w3lYGU7TWcCin6iJiGodALtCje1aK4TPAFAgAAHwEAAFBO.png?imageView2/1/w/480/h/266","http://3.im.guokr.com/W38qHMO8FpmkN_fa0yZvAUld7AP45ugG9d59AKAaKn4BAgAAHwEAAFBO.png?imageView2/1/w/480/h/268","http://1.im.guokr.com/Oyj-wX07Fx3DW-xAiXAw_iP3d2Hm349Z-5YJAr_x95H8AQAAPwEAAFBO.png?imageView2/1/w/480/h/301","http://1.im.guokr.com/iGCV9eT3Klm9ropPNDqiIX9A0agNlB7rvx5x-WGm6FTjAQAACwEAAFBO.png?imageView2/1/w/480/h/265","http://3.im.guokr.com/ZgfSP8jvYv5YFqJZIop0zNuNNFnT7pNKS0XUAUoEdSL_AQAAHQEAAFBO.png?imageView2/1/w/480/h/267","http://2.im.guokr.com/7K6mEZdm5RxBcZcDZdkDlMoUmiSjnIJCqBC-r8zsqT-9AQAA8wAAAFBO.png","http://2.im.guokr.com/LP7rQy-GTTK3Prcarf-_klhWBuoZxHC1HfQRPT89d1v5AQAADQEAAFBO.png?imageView2/1/w/480/h/255","http://1.im.guokr.com/-D9HAzR4enZ5L_smtSjGZ548GXuSxqHYmuA9h8bx0O3-AQAAIAEAAFBO.png?imageView2/1/w/480/h/271"],"video_duration":null,"id":82897,"category":"humanities","style":"article","title":"我是个剥削难民的器官贩子，但你得听我把话说完","source_data":{"image":"http://2.im.guokr.com/r8PINb_RG_niPP_rsxxvHLK7HmQE9i1NZD6pWV_0VDKgAAAAoAAAAFBO.png?imageView2/1/w/160/h/160","summary":"吸走你的无聊时间！","id":52,"key":"天了噜！","title":"天了噜！"},"headline_img_tb":"http://1.im.guokr.com/eZob3HShd7w3lYGU7TWcCin6iJiGodALtCje1aK4TPAFAgAAHwEAAFBO.png?imageView2/1/w/288/h/159","link_v2":"http://jingxuan.guokr.com/pick/v2/82897/","date_picked":1.49346006E9,"is_top":false,"link":"http://jingxuan.guokr.com/pick/82897/","headline_img":"http://1.im.guokr.com/eZob3HShd7w3lYGU7TWcCin6iJiGodALtCje1aK4TPAFAgAAHwEAAFBO.png","replies_count":3,"current_user_has_liked":false,"page_source":"http://jingxuan.guokr.com/pick/82897/?ad=1","author":"花生卷i","summary":"他叫阿布·加法（阿布 Jaafar），当然这只是一个化名。他的职业是人体器官走私贩，他的客户基本都是叙利亚难民。在这些难民的身体里","source":"group","reply_root_id":786427,"date_created":1.493359645E9},{"link_v2_sync_img":"http://jingxuan.guokr.com/pick/v2/82910/sync/","source_name":"物种日历","video_url":"","current_user_has_collected":false,"likings_count":5,"images":["http://2.im.guokr.com/Vf-64YyJ0DQiZhViH0MOFD0Wc42cdgk6dz5H8oi34jCYAgAA6AMAAEpQ.jpg","http://1.im.guokr.com/MlFMuTZiPYWO7K0BzI4pE8Up1ppbbDT50N3ZCZoKVmvoAwAAmQIAAEpQ.jpg","http://1.im.guokr.com/qWbnK3kXo3bpdD5nU0dCZJJlG_87mDEu7fN3brS9Z_xiBAAAGgMAAEpQ.jpg","http://3.im.guokr.com/9dSNCt5a-cGphDk6sr6vj-FxkfseL6cA1GsLSIiZcvToAwAAmQIAAEpQ.jpg","http://1.im.guokr.com/MgSdBdTF7NgOSskX06RFMmoz9EmIPJ5o9MzNqHTWz2GsAwAAywMAAEpQ.jpg","http://1.im.guokr.com/AhORRtojwi9zCKu4mx1C9zMmzr1pja6ZKvlyX9y0JwjoAwAAmgIAAEpQ.jpg","http://2.im.guokr.com/p3jxbWC30HrvISEbjzAePj1IimCVCPUlY8PcYhvkhMroAwAAnAIAAEpQ.jpg","http://3.im.guokr.com/pSQXLNt18g4LVAFgn4ViXKbth35Lkttv9QqU7utNTtnoAwAAmgIAAEpQ.jpg","http://1.im.guokr.com/20Y_-PXk0unVc1ds73m2u4scvrMim27V3BTAxgHxQsjoAwAAmwIAAEpQ.jpg","http://1.im.guokr.com/Ml28FvlaNb2fjhWQ8g8czxFrK-gCNvLcp0UVKpwJMO7oAwAAmwIAAEpQ.jpg","http://3.im.guokr.com/Ta239S29bp--UbY-zZ1kqF2gC4W3demCVNOrM6e2j0_oAwAAmwIAAEpQ.jpg","http://1.im.guokr.com/vQVqfIcxFiQBmcsP2js74yJA1kG53bze7tcqfqlpf2DoAwAAmgIAAEpQ.jpg","http://2.im.guokr.com/fy1b7eoM0jysSRDJXi2yPzgcCtgZtkMox6KxV23Y9ioABAAAHwMAAEpQ.jpg","http://3.im.guokr.com/FXdiFiwzMl-clARBGgCTfEqm1dU2KftJtUXjB1KQR33oAwAAnAIAAEpQ.jpg","http://1.im.guokr.com/PY9ZJh4AZ9UGcYDwTIjHXuA18qViQOSIssowOT4t_BPoAwAAnAIAAEpQ.jpg","http://3.im.guokr.com/wotxLSC9k2g3SRnmMdOKbH6nLhVgimZeL7Ju7xyy933oAwAA7gIAAEpQ.jpg","http://1.im.guokr.com/a2bjIz1PWOMECSdpjoictgekVMnLQ2pcH-042A_md1uYAgAA6AMAAEpQ.jpg","http://1.im.guokr.com/VoRip96WYL53C61-bIKNztB_Oq2nsquWGXiTfAsCL8voAwAAmgIAAEpQ.jpg","http://1.im.guokr.com/PZwAP-CKLM9ClOSxcAfDAjL7iIAbyj-k1WxVB3YBHt_oAwAAnAIAAEpQ.jpg","http://3.im.guokr.com/KZZXpli6ehWZjd4mE-WsjySEGqvXtFb7wOXOvigTORDoAwAAmgIAAEpQ.jpg","http://3.im.guokr.com/48n24mzvCRMY6qFW7Lz7BK6IWzukZocZkZtJALXSnojoAwAAmwIAAEpQ.jpg"],"video_duration":null,"id":82910,"category":"nature","style":"article","title":"这种中国本土猫科动物，全世界动物园只剩50只","source_data":{"image":"http://1.im.guokr.com/VvkCBwTkTvsNya95AjdtCjLCmXJTMiQEn5edxQrjBOLoAwAA6AMAAEpQ.jpg","summary":"每天一个物种，2016年，物种日历带你探索餐桌上的一切。","id":5,"key":"物种日历","title":"物种日历"},"headline_img_tb":"http://3.im.guokr.com/IRwXN7kHbqMju3eowcuQ4IBGxiNWkqJgV8j72bQNcC-AAgAArAEAAEpQ.jpg?imageView2/1/w/288/h/192","link_v2":"http://jingxuan.guokr.com/pick/v2/82910/","date_picked":1.49346E9,"is_top":false,"link":"http://jingxuan.guokr.com/pick/82910/","headline_img":"http://3.im.guokr.com/IRwXN7kHbqMju3eowcuQ4IBGxiNWkqJgV8j72bQNcC-AAgAArAEAAEpQ.jpg","replies_count":null,"current_user_has_liked":false,"page_source":"http://jingxuan.guokr.com/pick/82910/?ad=1","author":"baboon","summary":"你可能已经去过很多次动物园，五一假期，你可能还会去。今天我们来说一种动物园里不容易见到的本土猫科动物。如果见到它，你一定终身难忘。","source":"weixin","reply_root_id":0,"date_created":1.4933952E9},{"link_v2_sync_img":"http://jingxuan.guokr.com/pick/v2/82900/sync/","source_name":"天了噜！","video_url":"","current_user_has_collected":false,"likings_count":5,"images":["http://1.im.guokr.com/LTCHhrKLHDpA9U-D3pH2Ys-Z-0gn8z-rkyyaD3rZEUdSAgAADgIAAEpQ.jpg?imageView2/1/w/480/h/425","http://1.im.guokr.com/YL6A8UGfNgh1I7hDYmEeLmgOvVTwTQhpZEUyWDILL_5PAgAAPAIAAEpQ.jpg?imageView2/1/w/480/h/464","http://2.im.guokr.com/r0PpUdrD940-sTxW7mMZ1v-l-oWXsiKQs3-jKtP52Bo_AgAAHwIAAEpQ.jpg?imageView2/1/w/480/h/453","http://1.im.guokr.com/pDhpWvoSRhMJcjIidQdF7RLoRaR4h-ndfsRx0MrsZjbuAgAAMwIAAEpQ.jpg?imageView2/1/w/480/h/360","http://1.im.guokr.com/FyNg2J2VRtiKAKKoAdFK1b8GWUFVaWBT7-MGNijDKftRAgAAAQIAAEpQ.jpg?imageView2/1/w/480/h/415","http://1.im.guokr.com/2hYy3oGp_wqVN2CfO-UziE4lElTV04PGrwbZdLVM33TVAQAASAIAAEpQ.jpg","http://3.im.guokr.com/ELdYoykJ8G5KjJA_E1dfOIvylKUW57xhcgiV6OMmFJFAAQAAIwEAAEdJ.gif","http://3.im.guokr.com/cxx96aBMiSUmlUdlWDctDvu3v0THN1TF4SvIjJEBG65AAQAAMQEAAEdJ.gif","http://1.im.guokr.com/ixCzXZlNqmIhPE77VY3CMN3B_Eu0LaLsBHQazIUeyh58AQAA7QAAAEdJ.gif","http://1.im.guokr.com/VkyAj1YOFnz8013_RAW3Q-fUzPdQuSCascTg1OPEXXZ8AQAA1gAAAEdJ.gif","http://1.im.guokr.com/tPpzIklu1dda5uPdLn5tBTv0nEC5gDSpXzC5ABPAc4iJAgAACAIAAEpQ.jpg?imageView2/1/w/480/h/384"],"video_duration":null,"id":82900,"category":"humanities","style":"article","title":"冰棍插满墙！这是一个属于冰淇淋爱好者的博物馆","source_data":{"image":"http://2.im.guokr.com/r8PINb_RG_niPP_rsxxvHLK7HmQE9i1NZD6pWV_0VDKgAAAAoAAAAFBO.png?imageView2/1/w/160/h/160","summary":"吸走你的无聊时间！","id":52,"key":"天了噜！","title":"天了噜！"},"headline_img_tb":"http://1.im.guokr.com/tPpzIklu1dda5uPdLn5tBTv0nEC5gDSpXzC5ABPAc4iJAgAACAIAAEpQ.jpg?imageView2/1/w/288/h/230","link_v2":"http://jingxuan.guokr.com/pick/v2/82900/","date_picked":1.49346E9,"is_top":false,"link":"http://jingxuan.guokr.com/pick/82900/","headline_img":"http://1.im.guokr.com/tPpzIklu1dda5uPdLn5tBTv0nEC5gDSpXzC5ABPAc4iJAgAACAIAAEpQ.jpg?imageView2/1/w/640/h/480","replies_count":0,"current_user_has_liked":false,"page_source":"http://jingxuan.guokr.com/pick/82900/?ad=1","author":"親子丼","summary":"这是美国的一个\u201c冰淇淋博物馆\u201d： 所以在这里，人们会学到冰淇淋的历史，还有制作冰淇淋的科学知识吗？这还真不是重点。 推开冰淇淋博物","source":"group","reply_root_id":786471,"date_created":1.493373889E9},{"link_v2_sync_img":"http://jingxuan.guokr.com/pick/v2/82905/sync/","source_name":"天了噜！","video_url":"","current_user_has_collected":false,"likings_count":5,"images":["http://2.im.guokr.com/ib1g2zpMq6WupVvZKJQGpHByvLpza73x6xORb4YX8jK8AgAAvAIAAEpQ.jpg?imageView2/1/w/480/h/480","http://2.im.guokr.com/lhxAf7IZ02vIa9K-4sT8eG1U0Uf41-GYEP1fkH9RTlq8AgAA0gEAAEpQ.jpg?imageView2/1/w/480/h/319","http://1.im.guokr.com/bU4vJroOy3sC8wrKf9GM_YwcGzZTG6Z4Ve2KhrCdAWS8AgAAtgEAAEpQ.jpg?imageView2/1/w/480/h/300","http://1.im.guokr.com/Enpn9TnpyUz5pIZkcF-h2wjeM0J2bn1xDqzOxXy3Uee8AgAA0gEAAEpQ.jpg?imageView2/1/w/480/h/319","http://2.im.guokr.com/Qr8GapXOC1VnllyOOS1tbR10h12qgVrXo794a7mQ4XG8AgAA2gEAAEpQ.jpg?imageView2/1/w/480/h/325","http://3.im.guokr.com/_eGyQNzWhjoDHdQKC-7YoYZ_IbMPP8kZP8pjApc-b5ptAQAAzQAAAEdJ.gif","http://1.im.guokr.com/yjFHOV0-qnGgtG8fNIhPPi-MQTTQmOlEpBnS4IfED94KAQAAzgAAAEdJ.gif"],"video_duration":null,"id":82905,"category":"nature","style":"article","title":"前方高萌注意！这里有一波超可爱的象宝宝们正在向你卖萌","source_data":{"image":"http://2.im.guokr.com/r8PINb_RG_niPP_rsxxvHLK7HmQE9i1NZD6pWV_0VDKgAAAAoAAAAFBO.png?imageView2/1/w/160/h/160","summary":"吸走你的无聊时间！","id":52,"key":"天了噜！","title":"天了噜！"},"headline_img_tb":"http://2.im.guokr.com/lhxAf7IZ02vIa9K-4sT8eG1U0Uf41-GYEP1fkH9RTlq8AgAA0gEAAEpQ.jpg?imageView2/1/w/288/h/191","link_v2":"http://jingxuan.guokr.com/pick/v2/82905/","date_picked":1.49346E9,"is_top":false,"link":"http://jingxuan.guokr.com/pick/82905/","headline_img":"http://2.im.guokr.com/lhxAf7IZ02vIa9K-4sT8eG1U0Uf41-GYEP1fkH9RTlq8AgAA0gEAAEpQ.jpg?imageView2/1/w/640/h/480","replies_count":0,"current_user_has_liked":false,"page_source":"http://jingxuan.guokr.com/pick/82905/?ad=1","author":"胖豆瘦瘦瘦","summary":"众所周知，象是目前陆地上最大的哺乳动物。虽然它们体型庞大，但是它们卖起萌却丝毫不逊色于其他小萌物们！尤其是卖萌的象宝宝们简直是可爱","source":"group","reply_root_id":786455,"date_created":1.49336827E9},{"link_v2_sync_img":"http://jingxuan.guokr.com/pick/v2/82906/sync/","source_name":"天了噜！","video_url":"","current_user_has_collected":false,"likings_count":6,"images":["http://2.im.guokr.com/VhQyF2RwBoOmtF0BUTWisPgvzVy2TjyGLFQFmyaj9rggAwAA4gEAAEpQ.jpg?imageView2/1/w/480/h/289","http://3.im.guokr.com/sHIysh9YxwWar45HhFOC05L7B8CIuxSEL478rywwNCcAAQAA4AAAAFBO.png","http://1.im.guokr.com/87uv8BwZBtMt_1OTSslbfuM56NnM7DrxhSMGTK9AGRItAQAALQEAAEpQ.jpg","http://1.im.guokr.com/rzOxjX52xjUEKLBoJjexl4T-w9Rd1Wd1TrXCiwePeMTIAAAAyAAAAEpQ.jpg","http://1.im.guokr.com/XCf32Pw6IFBq15LNPLvw4fLYEIrWo1tb4NvPMSEJLiKDAQAAgwEAAEpQ.jpg","http://3.im.guokr.com/f9xNBAxJxUXMw1l8NMo4N03G3GwqUyC2i_QwHlknEt0gAwAAFQIAAFBO.png?imageView2/1/w/480/h/319","http://3.im.guokr.com/yWsN81hM1MbXge27-ujwN1QBREDT2xt92I973fVk7HB8AgAAjgEAAFBO.png?imageView2/1/w/480/h/300","http://3.im.guokr.com/WYaAcwN9Xf_KLmm4U95csQPZWJ-mgqFbm0s6E2FimfkAAQAA4AAAAFBO.png","http://3.im.guokr.com/C7TVjyL-I5q8vKSP4MtADwndldnNz4RigdpGRBFD4oCjAAAAnAAAAEpQ.jpg","http://2.im.guokr.com/QxFd9npyoh6LgdppkZ3BVLmHnuYIoqspFobn0oKsNVN7AgAATgIAAFBO.png?imageView2/1/w/480/h/445","http://1.im.guokr.com/pLmrp_azGqceDfwXKIYQPd58HtdMFZonQOYzkbbypLCdAAAAoAAAAEpQ.jpg","http://2.im.guokr.com/FKoOWNNCHYBWHBRAaR0nMYAVKmrFkyvF2dFSBAIh1rXEAAAAxAAAAEpQ.jpg"],"video_duration":null,"id":82906,"category":"game","style":"article","title":"三个孩子英化《最终幻想5》 效果秒杀官方美版","source_data":{"image":"http://2.im.guokr.com/r8PINb_RG_niPP_rsxxvHLK7HmQE9i1NZD6pWV_0VDKgAAAAoAAAAFBO.png?imageView2/1/w/160/h/160","summary":"吸走你的无聊时间！","id":52,"key":"天了噜！","title":"天了噜！"},"headline_img_tb":"http://2.im.guokr.com/VhQyF2RwBoOmtF0BUTWisPgvzVy2TjyGLFQFmyaj9rggAwAA4gEAAEpQ.jpg?imageView2/1/w/288/h/173","link_v2":"http://jingxuan.guokr.com/pick/v2/82906/","date_picked":1.49346E9,"is_top":false,"link":"http://jingxuan.guokr.com/pick/82906/","headline_img":"http://2.im.guokr.com/VhQyF2RwBoOmtF0BUTWisPgvzVy2TjyGLFQFmyaj9rggAwAA4gEAAEpQ.jpg?imageView2/1/w/640/h/480","replies_count":1,"current_user_has_liked":false,"page_source":"http://jingxuan.guokr.com/pick/82906/?ad=1","author":"Clapperboard","summary":"上世纪90年代，Myria走进高中的计算机教室，发现有个男孩在玩《最终幻想5》。 《最终幻想5》官方美版当时还没发售，想玩英文游戏","source":"group","reply_root_id":786453,"date_created":1.493367441E9},{"link_v2_sync_img":"http://jingxuan.guokr.com/pick/v2/82904/sync/","source_name":"天了噜！","video_url":"","current_user_has_collected":false,"likings_count":9,"images":["http://2.im.guokr.com/x75aJc57EklQrnLDfPgfnNwjGKqmox4n_Su8pTsn0FEABQAA0AIAAEpQ.jpg?imageView2/1/w/480/h/270","http://2.im.guokr.com/InstbK4DB-iqgIIJHL3mu17FFa_BqY2J-V-e10-Tum7iBQAAOwMAAEpQ.jpg?imageView2/1/w/480/h/263","http://2.im.guokr.com/2fvgmQkGsCTMev18YMLVVAStJR56P1CZNJonVfYzj7CQAQAAfwEAAEdJ.gif","http://1.im.guokr.com/_srhTEYBgLGnNk_sTTULQ_wHmzDFpnPD1FXJT2gRPIyQAQAAfwEAAEdJ.gif","http://3.im.guokr.com/5bCJk6EabOXrX38qQxNOf3AJ7W7A9oUnBHHbzLf4ARKQAQAAfwEAAEdJ.gif","http://1.im.guokr.com/I0o-H6lq9t01Y6aTnmObbG5_Lh28fRHteLK5503DxziQAQAAfwEAAEdJ.gif","http://1.im.guokr.com/mt-jqLkQEo40N7umXqoFKgKOfarhi07_P1RCNGfRzaCQAQAAfwEAAEdJ.gif","http://2.im.guokr.com/EGYMmSayculbvHp5QuMF_N_R6QRjebfbACX-d7_2hpKQAQAAfwEAAEdJ.gif","http://3.im.guokr.com/OKUgv8QNkkL4pC8ruiZh-fFLrW_ux821MCIDoZyadNndAQAA7gIAAEpQ.jpg"],"video_duration":null,"id":82904,"category":"game","style":"article","title":"翻身做主人的小蜘蛛：这个洛圣都我要了","source_data":{"image":"http://2.im.guokr.com/r8PINb_RG_niPP_rsxxvHLK7HmQE9i1NZD6pWV_0VDKgAAAAoAAAAFBO.png?imageView2/1/w/160/h/160","summary":"吸走你的无聊时间！","id":52,"key":"天了噜！","title":"天了噜！"},"headline_img_tb":"http://2.im.guokr.com/x75aJc57EklQrnLDfPgfnNwjGKqmox4n_Su8pTsn0FEABQAA0AIAAEpQ.jpg?imageView2/1/w/288/h/162","link_v2":"http://jingxuan.guokr.com/pick/v2/82904/","date_picked":1.49346E9,"is_top":false,"link":"http://jingxuan.guokr.com/pick/82904/","headline_img":"http://2.im.guokr.com/x75aJc57EklQrnLDfPgfnNwjGKqmox4n_Su8pTsn0FEABQAA0AIAAEpQ.jpg?imageView2/1/w/640/h/480","replies_count":2,"current_user_has_liked":false,"page_source":"http://jingxuan.guokr.com/pick/82904/?ad=1","author":"ZafriLiao","summary":"如果要问你最喜欢的漫威英雄是哪个，可能不少粉丝会异口同声的说：\u201c蜘蛛侠。\u201d 如果要问你最喜欢的游戏大作是哪个，一定也会有很多人说：","source":"group","reply_root_id":786366,"date_created":1.493344647E9},{"link_v2_sync_img":"http://jingxuan.guokr.com/pick/v2/82908/sync/","source_name":"第十三味","video_url":"","current_user_has_collected":false,"likings_count":8,"images":["http://1.im.guokr.com/NCyHT3pkdzan9fkoHjemvyNTYDaEe5LnzrS8FNXdakiwBAAAWQYAAEpQ.jpg","http://3.im.guokr.com/Y4wXYpT-nWKX_wqGXfSUqByrGi4mxI7KjWOWg-BZ0QwABQAAIgQAAEpQ.jpg","http://3.im.guokr.com/vRWRdKz6gzL_QceHS-UtZ1zqvWFmR6D03vMwerYJIG4ABQAAAwQAAEpQ.jpg","http://2.im.guokr.com/gXDcBMM2fDbLE6Mq6sGfElAJq8ZXpJpptBMvovMKlRzmBAAAAAQAAEpQ.jpg","http://3.im.guokr.com/hEO_kUCYJkNFZ_bUEtuKOqUViNOgYm2YEmQqEFbrdH8ABQAADgQAAEpQ.jpg","http://3.im.guokr.com/4DO66vj-ddbbAwibTj0YogXdpgoIL3x6J3NhRfB4rsMABAAAQQMAAEpQ.jpg","http://1.im.guokr.com/xkQ0kYS2wFzAVAGARJ1jAOJxUZ2KdSc4J_Svuq3yzqgABQAAEwQAAEpQ.jpg","http://1.im.guokr.com/y3Cb71cxhjMLZFrjXHOrvlhACZHdsIcDPNVbOmeMHe0ABQAAHgYAAEpQ.jpg","http://2.im.guokr.com/-2bowh2dUvUTdsVKa7vIdHnWHe_0ZzLbg5YJv8i8q4cABQAAKgQAAEpQ.jpg","http://3.im.guokr.com/-PivqYwZIx5Uk4tbG0xTepDJ_RQwQ-unSlQOnCFrhkkrBAAAagMAAEpQ.jpg","http://2.im.guokr.com/3QgE6Yb2B1iBxl0XaNRMclSgnlMls39KLNru-tQaPExYAwAA8AMAAEpQ.jpg","http://1.im.guokr.com/2uOgevRrI4IauLyFQIF1fhlRfE8ZehGNYLP1DKxHSoiNAwAAVgQAAEpQ.jpg","http://1.im.guokr.com/Ab8xxPWM0gSRD4gIBhY9vTrKZiwKCF0MYUHXsfhpdT_UAgAAfQMAAEpQ.jpg","http://2.im.guokr.com/MjnNEIzlgi7i0vY8XXT0YKHI4uLBv71HPtjqPfs5f6MABQAABgYAAEpQ.jpg","http://3.im.guokr.com/QBveR_kPNZXUe69t7f-pY68kMcqGCAQOmcqDfuZp8JUABAAAJgMAAEpQ.jpg","http://3.im.guokr.com/eAwpHIDKby4Xp7k6QDvZU-pRSHFC5RYTWeBZ1VAs5GgoAwAA5wMAAEpQ.jpg","http://2.im.guokr.com/WxAZW1Msi3KBrrbnEfrWRCo65uhHSs4D73QYs0p2S7QABQAADgQAAEpQ.jpg","http://1.im.guokr.com/SDK6OW0QkYZrD4AVFYJPcdJ7y1x2nRq1EgM8kEyjM8QABAAAVwMAAEpQ.jpg","http://1.im.guokr.com/3BJwyLNt1oblD_nseqb4QEwSc6atGM8xT3vf8eRcUUAABQAAEgQAAEpQ.jpg","http://3.im.guokr.com/9SViDsTz0Cle0WYzBhJwPBsHX6KOYiAhYhlTotwdmjIWAgAAigIAAEpQ.jpg","http://2.im.guokr.com/Nv1DK1TEomqnED4Uma-saqpOyGG-CLCsBBHwv4h0bfsABQAAKgQAAEpQ.jpg","http://3.im.guokr.com/Y20e0UXqX2MvKvpnLkNiTuZi5y9_QaYSwrNuhTadZxEABQAAJAQAAEpQ.jpg"],"video_duration":null,"id":82908,"category":"humanities","style":"article","title":"美图欣赏 | John Sloan","source_data":{"image":"http://1.im.guokr.com/aKATAY6m-SDO2HY7BNMhoaqb6bvIan3p1RgZyLZS5EUxAgAAMwIAAEpQ.jpg","summary":"每天一位艺术家推荐，通过数量提高你的眼界。","id":20,"key":"第十三味","title":"第十三味"},"headline_img_tb":"http://3.im.guokr.com/hzXJdw4M8U0kJiS4PAYMfiQ6DEYCtqJ_A4elQNIjI7R8AgAAAAIAAFBO.png?imageView2/1/w/288/h/231","link_v2":"http://jingxuan.guokr.com/pick/v2/82908/","date_picked":1.49346E9,"is_top":false,"link":"http://jingxuan.guokr.com/pick/82908/","headline_img":"http://3.im.guokr.com/hzXJdw4M8U0kJiS4PAYMfiQ6DEYCtqJ_A4elQNIjI7R8AgAAAAIAAFBO.png","replies_count":null,"current_user_has_liked":false,"page_source":"http://jingxuan.guokr.com/pick/82908/?ad=1","author":"十三","summary":"John Sloan 1871-1951 美国艺术家，描绘20世纪早期纽约的平民日常生活场景，在当时具有政治反叛精神。","source":"weixin","reply_root_id":0,"date_created":1.4933088E9},{"link_v2_sync_img":"http://jingxuan.guokr.com/pick/v2/82898/sync/","source_name":"天了噜！","video_url":"","current_user_has_collected":false,"likings_count":8,"images":["http://1.im.guokr.com/WaQJxFanPbljjXxOLwn6VaB80NoZeCIpKk46c9PIzTxNAQAAlwAAAFBO.png","http://3.im.guokr.com/gOzE0xdSs-Ic4ginkkY9KHfB4LBUtvRN7qLOTdP1X9N1AQAAWAAAAFBO.png","http://2.im.guokr.com/TCk579LOXj7Cef9_GFFBA_AqJkBZi7Xhw67wYrhLaRBSAgAAXAEAAEdJ.gif?imageView2/1/w/480/h/281","http://3.im.guokr.com/P6hgGJcqw3jGP7r5v7cAi8vlEx75Jm6rFJht5_ycBHG4AQAAuAEAAEpQ.jpg","http://1.im.guokr.com/w2J9pTr24FyAw55N0bjvSttkJ2XEJULvKBqbyQhhJP-JAgAAzwIAAFBO.png?imageView2/1/w/480/h/531","http://2.im.guokr.com/_1JwslDgRYcHvKrlrxZLMt4BnG16GQQ-MSo2Wh4njJJSAgAAXAEAAEdJ.gif?imageView2/1/w/480/h/281","http://3.im.guokr.com/LwOEmExuVGeezYlo5MLqPmnmZkpJfzQp7anZmyj_eF_6BAAAzQIAAEpQ.jpg?imageView2/1/w/480/h/270","http://3.im.guokr.com/m-13TiuXHqRUqSNCHnLL60XNGYAtfvA0077KJ4bkuuOdBAAAxgIAAEpQ.jpg?imageView2/1/w/480/h/288","http://1.im.guokr.com/ebe9KsEZjjUDLUIqDA7uErGt5EYCwbZC0VseRKUEuB-dBAAAzAIAAEpQ.jpg?imageView2/1/w/480/h/291","http://1.im.guokr.com/WsbmHt1s7Rxv1lxxxJeCCWyoKiTArQs_LD8pzlNIpAbsBAAAiwIAAEpQ.jpg?imageView2/1/w/480/h/248","http://1.im.guokr.com/j6cRmS1gb2RlVCJ7J4TqI3WDh_mKesnpnV4s5Not69p1AQAA-gAAAEdJ.gif","http://2.im.guokr.com/btBH5liHItFd1XwR0ysuf6I-mqoKGB9EeuhBNbGKcFe0AgAApgEAAFBO.png?imageView2/1/w/480/h/292","http://2.im.guokr.com/oKCA4VlZdrtjfDaIzJ7W5Jcef94Vmi0zotm8__GIlsC5BAAAcAIAAEpQ.jpg?imageView2/1/w/480/h/247","http://1.im.guokr.com/UgiICJsFtSDonWrI7s3VIquGRyyHycYdqITbc91Y2KcsAQAAFAEAAEpQ.jpg","http://2.im.guokr.com/Pa3dja0zkR6huOORngE8eGIAeP6euVSjZYSA12MiuNLTAQAAVQEAAFBO.png","http://1.im.guokr.com/Q4dxk6QOODCObtYZp7i-yjQxw8LXHQj7dYV_PanMPLDMAQAAVQEAAFBO.png","http://3.im.guokr.com/Ek1SIkSyqV7GPY-fge6BDt_a923k8ACRVHUW5zoncnN0AgAA4gAAAFBO.png?imageView2/1/w/480/h/172","http://1.im.guokr.com/kr2i2_COZEjQ_9nnNpkZ8IjinAq4nqu5FPZi35kVrOZqAgAAhAAAAFBO.png?imageView2/1/w/480/h/102","http://1.im.guokr.com/v6uT-udmTAqqLAQPn8uv-nigNQNNp0l72uaphSWAAGvbAQAAjgEAAFBO.png","http://1.im.guokr.com/HpmXH0TNYPd65MYyHlNOxGLzRLvXHDxX4GTd1QLoM4qUAQAAGAEAAFBO.png","http://2.im.guokr.com/oA-30OfZdTb_lMpJLo3dy-Q0Ph2LLzJlrpQc_MzLJCdvAQAA-gAAAFBO.png","http://3.im.guokr.com/9jKc1omPpLhqKftuLmRI60QTAKQRWI0RvuAE-TggRxNYAgAAwgEAAEpQ.jpg?imageView2/1/w/480/h/360","http://3.im.guokr.com/01ou6WyRxNElWwLyh4D3uAlCEU0JjXzbUJ4_UQnb88TwAAAA8AAAAEpQ.jpg"],"video_duration":null,"id":82898,"category":"game","style":"article","title":"这位朋友，我看你体格壮硕，样貌英武，要不要一起爬♂山呢？","source_data":{"image":"http://2.im.guokr.com/r8PINb_RG_niPP_rsxxvHLK7HmQE9i1NZD6pWV_0VDKgAAAAoAAAAFBO.png?imageView2/1/w/160/h/160","summary":"吸走你的无聊时间！","id":52,"key":"天了噜！","title":"天了噜！"},"headline_img_tb":"http://1.im.guokr.com/WaQJxFanPbljjXxOLwn6VaB80NoZeCIpKk46c9PIzTxNAQAAlwAAAFBO.png?imageView2/1/w/288/h/130","link_v2":"http://jingxuan.guokr.com/pick/v2/82898/","date_picked":1.49346E9,"is_top":false,"link":"http://jingxuan.guokr.com/pick/82898/","headline_img":"http://1.im.guokr.com/WaQJxFanPbljjXxOLwn6VaB80NoZeCIpKk46c9PIzTxNAQAAlwAAAFBO.png","replies_count":6,"current_user_has_liked":false,"page_source":"http://jingxuan.guokr.com/pick/82898/?ad=1","author":"山啾","summary":"某一天的早晨，我打开电脑，习惯性地登陆了steam，选择打折商品，按照评价排序。 然后一个奇怪的图标吸引了我的注意力··· 《伙伴","source":"group","reply_root_id":786350,"date_created":1.493306472E9},{"link_v2_sync_img":"http://jingxuan.guokr.com/pick/v2/82902/sync/","source_name":"天了噜！","video_url":"","current_user_has_collected":false,"likings_count":7,"images":["http://1.im.guokr.com/KJI4tjkV5rp8aJselpS_ZSBFxBp7SpZumA86h6Bzwux6AgAApwEAAEpQ.jpg?imageView2/1/w/480/h/320"],"video_duration":null,"id":82902,"category":"funny","style":"article","title":"什么才是最糟糕的求婚场景？看完我只服网友评论！","source_data":{"image":"http://2.im.guokr.com/r8PINb_RG_niPP_rsxxvHLK7HmQE9i1NZD6pWV_0VDKgAAAAoAAAAFBO.png?imageView2/1/w/160/h/160","summary":"吸走你的无聊时间！","id":52,"key":"天了噜！","title":"天了噜！"},"headline_img_tb":"http://1.im.guokr.com/KJI4tjkV5rp8aJselpS_ZSBFxBp7SpZumA86h6Bzwux6AgAApwEAAEpQ.jpg?imageView2/1/w/288/h/192","link_v2":"http://jingxuan.guokr.com/pick/v2/82902/","date_picked":1.49346E9,"is_top":false,"link":"http://jingxuan.guokr.com/pick/82902/","headline_img":"http://1.im.guokr.com/KJI4tjkV5rp8aJselpS_ZSBFxBp7SpZumA86h6Bzwux6AgAApwEAAEpQ.jpg","replies_count":0,"current_user_has_liked":false,"page_source":"http://jingxuan.guokr.com/pick/82902/?ad=1","author":"席地饮茶","summary":"电影中的求婚场景总是那么浪漫，让人充满了幻想，可是现实生活中就未必了，有的时候甚至会很糟糕！这些关于求婚的反面教材，广大单身汪们注","source":"group","reply_root_id":786341,"date_created":1.493301542E9},{"link_v2_sync_img":"http://jingxuan.guokr.com/pick/v2/82901/sync/","source_name":"天了噜！","video_url":"","current_user_has_collected":false,"likings_count":5,"images":["http://1.im.guokr.com/xiyCRBsqyK165Z0Gw9HKZMYXwLbBKUikFwAgq2_XppEgAwAA8QEAAEpQ.jpg?imageView2/1/w/480/h/298","http://2.im.guokr.com/MJRx9raNOs5jWq6w8wksgjfBfguC3y5fyeT1sLc8sLUgAwAAsAQAAEpQ.jpg?imageView2/1/w/480/h/720","http://2.im.guokr.com/nngHRu1ZvXLX6l_Syh1-4bgGGxUaWYAIXobCGx2UuisgAwAAsAQAAEpQ.jpg?imageView2/1/w/480/h/720","http://3.im.guokr.com/ADQjclUvkmAEYywVxac0bewhVT-UIUk1CTP9knmbr2ggAwAAFQIAAEpQ.jpg?imageView2/1/w/480/h/319","http://3.im.guokr.com/vme-j8yJ2RQstO6FG1v97qfZbd65sGXwjifQ3hKnPF4gAwAALgQAAEpQ.jpg?imageView2/1/w/480/h/642","http://2.im.guokr.com/YJPI_8kbT62xy5dHCetDxDp0_xkaAvdfmut0MV6pNuQgAwAAsAQAAEpQ.jpg?imageView2/1/w/480/h/720","http://3.im.guokr.com/JsIsakR6jSqm4IzHEvHgb5TiutYF15uT66qyigkOJXIgAwAAsAQAAEpQ.jpg?imageView2/1/w/480/h/720","http://3.im.guokr.com/FcmKvz_mfBjju91ZA7nLuO94t_puUimzqAB6FhlaSRsgAwAAsAQAAEpQ.jpg?imageView2/1/w/480/h/720","http://1.im.guokr.com/ZG8OjIPvneVPOb8vSNftiqXL2DE0011iwQYJmKd2exEgAwAAsAQAAEpQ.jpg?imageView2/1/w/480/h/720","http://2.im.guokr.com/f5Vjlh4CSedJuTVMvTthHwZwLaFbLlcIzwE7okWbGeQgAwAAsAQAAEpQ.jpg?imageView2/1/w/480/h/720","http://3.im.guokr.com/HMv_656QsWe-0KoutXuKJtQeAHW7uPtl9NrwsJxsFNIgAwAAJwQAAEpQ.jpg?imageView2/1/w/480/h/637","http://2.im.guokr.com/ULS553xNKT4610UBtTM96V2Th1k_nHdcHSqDwxphDEl8AgAAUAMAAEpQ.jpg?imageView2/1/w/480/h/640","http://1.im.guokr.com/Vwe7V7Uq0IZv-liqqtv9r06uCNkztUrKTBCMYi3_s3ogAwAAJwQAAEpQ.jpg?imageView2/1/w/480/h/637","http://2.im.guokr.com/YOJ3aqj_0etFX94EZInO8JwmImD9YEnbHJCkWb-GQecgAwAAKwQAAEpQ.jpg?imageView2/1/w/480/h/640"],"video_duration":null,"id":82901,"category":"humanities","style":"article","title":"这些精美迪士尼海报，带你重返童年","source_data":{"image":"http://2.im.guokr.com/r8PINb_RG_niPP_rsxxvHLK7HmQE9i1NZD6pWV_0VDKgAAAAoAAAAFBO.png?imageView2/1/w/160/h/160","summary":"吸走你的无聊时间！","id":52,"key":"天了噜！","title":"天了噜！"},"headline_img_tb":"http://1.im.guokr.com/xiyCRBsqyK165Z0Gw9HKZMYXwLbBKUikFwAgq2_XppEgAwAA8QEAAEpQ.jpg?imageView2/1/w/288/h/178","link_v2":"http://jingxuan.guokr.com/pick/v2/82901/","date_picked":1.49346E9,"is_top":false,"link":"http://jingxuan.guokr.com/pick/82901/","headline_img":"http://1.im.guokr.com/xiyCRBsqyK165Z0Gw9HKZMYXwLbBKUikFwAgq2_XppEgAwAA8QEAAEpQ.jpg?imageView2/1/w/640/h/480","replies_count":0,"current_user_has_liked":false,"page_source":"http://jingxuan.guokr.com/pick/82901/?ad=1","author":"淡墨痕c","summary":"很多人都是看着迪士尼的动画片长大的。自1930年起，Walt Disney和他的公司就开始大量生产卡通电影来供家人观赏，这周，Mo","source":"group","reply_root_id":786338,"date_created":1.493295941E9},{"link_v2_sync_img":"http://jingxuan.guokr.com/pick/v2/82899/sync/","source_name":"天了噜！","video_url":"","current_user_has_collected":false,"likings_count":9,"images":["http://1.im.guokr.com/_w3W7tBxY2kXnbPH3zCCMptoGnkRUULezK8MQZsVSCXgAQAAAgEAAEdJ.gif","http://1.im.guokr.com/F_-dAnuYQ-45DjDMbWciwrbb3Bdx49OMeLMBY8iwlGQqAwAAGwIAAEpQ.jpg?imageView2/1/w/480/h/319","http://1.im.guokr.com/mOwn54O3jaFS-q-RSL8XdtJ1W8Luiedq-drbLngm28iXAQAACwEAAEpQ.jpg","http://3.im.guokr.com/U4QBx9w3w2x8zrEL3gsjnfTk0DomzQAfVc04kI5-Vy2AAgAAcgQAAEpQ.jpg?imageView2/1/w/480/h/853","http://3.im.guokr.com/CNAjyhpSaIHMIEydC6JQwWoqFFvb2tagWu5jO3wKBp9LAQAA_gAAAFBO.png"],"video_duration":null,"id":82899,"category":"humanities","style":"article","title":"美联航是真知道错了，竟然推出了这项服务。。。","source_data":{"image":"http://2.im.guokr.com/r8PINb_RG_niPP_rsxxvHLK7HmQE9i1NZD6pWV_0VDKgAAAAoAAAAFBO.png?imageView2/1/w/160/h/160","summary":"吸走你的无聊时间！","id":52,"key":"天了噜！","title":"天了噜！"},"headline_img_tb":"http://3.im.guokr.com/CNAjyhpSaIHMIEydC6JQwWoqFFvb2tagWu5jO3wKBp9LAQAA_gAAAFBO.png?imageView2/1/w/288/h/221","link_v2":"http://jingxuan.guokr.com/pick/v2/82899/","date_picked":1.49346E9,"is_top":false,"link":"http://jingxuan.guokr.com/pick/82899/","headline_img":"http://3.im.guokr.com/CNAjyhpSaIHMIEydC6JQwWoqFFvb2tagWu5jO3wKBp9LAQAA_gAAAFBO.png","replies_count":14,"current_user_has_liked":false,"page_source":"http://jingxuan.guokr.com/pick/82899/?ad=1","author":"Freude_63192","summary":"前阵子的暴力逐机事件让美联航简直成了过街老鼠。最近为了挽回自己的公众形象，体现自己的忏悔之心，美联航推出了一项新服务：如果再发生超","source":"group","reply_root_id":786335,"date_created":1.493294283E9},{"link_v2_sync_img":"http://jingxuan.guokr.com/pick/v2/82894/sync/","source_name":"天了噜！","video_url":"","current_user_has_collected":false,"likings_count":5,"images":["http://3.im.guokr.com/xqziF3B4RK5QZ2n1TtyJtL-FV0yCv-86H2v7vGrvUDwsAQAAVAEAAFBO.png","http://1.im.guokr.com/MPNLVMKkabl3berA2WjmoCiUzlOYcaCUvSYlhLqbbmwrAQAAUQEAAFBO.png","http://3.im.guokr.com/2vVghTvQa64JSMvTCgV1mgVZD5uWdM5LvHa2uOVhdD8vAQAAUgEAAFBO.png","http://3.im.guokr.com/lsD5MiBlnBfxmoxH03HjR6zq8y1YZwEwxLVQ-2II4vyWAQAA0AIAAEdJ.gif","http://1.im.guokr.com/FNxceJZ1C1gWgR7APbgqmRc5YoB6546UIRr3PbNhUtUvAQAAUgEAAEpQ.jpg","http://2.im.guokr.com/7J7Srzqg1bmWMOHbRLXaKPUto7Qw1C_CSRphhrMZudAvAQAAUgEAAEpQ.jpg","http://1.im.guokr.com/AF0F8LSvI5X3m5XeZAFmL3ny4MP_twwToKuyJyIc3XcvAQAAUgEAAEpQ.jpg"],"video_duration":null,"id":82894,"category":"gossip","style":"article","title":"骑摩托车被蛇攻击！泰国小伙儿神反应躲过一劫","source_data":{"image":"http://2.im.guokr.com/r8PINb_RG_niPP_rsxxvHLK7HmQE9i1NZD6pWV_0VDKgAAAAoAAAAFBO.png?imageView2/1/w/160/h/160","summary":"吸走你的无聊时间！","id":52,"key":"天了噜！","title":"天了噜！"},"headline_img_tb":"http://3.im.guokr.com/2vVghTvQa64JSMvTCgV1mgVZD5uWdM5LvHa2uOVhdD8vAQAAUgEAAFBO.png?imageView2/1/w/288/h/321","link_v2":"http://jingxuan.guokr.com/pick/v2/82894/","date_picked":1.49346E9,"is_top":false,"link":"http://jingxuan.guokr.com/pick/82894/","headline_img":"http://3.im.guokr.com/2vVghTvQa64JSMvTCgV1mgVZD5uWdM5LvHa2uOVhdD8vAQAAUgEAAFBO.png","replies_count":0,"current_user_has_liked":false,"page_source":"http://jingxuan.guokr.com/pick/82894/?ad=1","author":"屋塔房","summary":"是不是觉得没事被蛇攻击的概率很低？骑摩托车还被攻击的概率就更低了？ 然而这么倒霉的事却被一位泰国南邦的小伙子碰上了！ 小伙子，你这","source":"group","reply_root_id":786333,"date_created":1.493290651E9},{"link_v2_sync_img":"http://jingxuan.guokr.com/pick/v2/82889/sync/","source_name":"天了噜！","video_url":"","current_user_has_collected":false,"likings_count":9,"images":["http://1.im.guokr.com/UN8rjCVyebZgmUPv7hC-JysD_b1CbzmnDu5akgfgcfJYAgAAUAEAAEpQ.jpg?imageView2/1/w/480/h/268","http://2.im.guokr.com/1wxO98HVio4LSjFEKb-xGK5xqkoiuC8girVnw3_B1iReAQAAYQMAAFBO.png","http://1.im.guokr.com/BwiKYOJqDHbDZ3r-TrSBn2Wj92tZrSFewhT8HpKKqzOyAgAAsgIAAEpQ.jpg?imageView2/1/w/480/h/480","http://1.im.guokr.com/Iiml-qBIE1V2-z2jimCmNotbp2GhQ9b1cLHlvFgof-DIAAAAwAAAAEpQ.jpg"],"video_duration":null,"id":82889,"category":"health","style":"article","title":"看到大盘美食就停不下来？这是脑子的问题！","source_data":{"image":"http://2.im.guokr.com/r8PINb_RG_niPP_rsxxvHLK7HmQE9i1NZD6pWV_0VDKgAAAAoAAAAFBO.png?imageView2/1/w/160/h/160","summary":"吸走你的无聊时间！","id":52,"key":"天了噜！","title":"天了噜！"},"headline_img_tb":"http://1.im.guokr.com/UN8rjCVyebZgmUPv7hC-JysD_b1CbzmnDu5akgfgcfJYAgAAUAEAAEpQ.jpg?imageView2/1/w/288/h/161","link_v2":"http://jingxuan.guokr.com/pick/v2/82889/","date_picked":1.49343846E9,"is_top":false,"link":"http://jingxuan.guokr.com/pick/82889/","headline_img":"http://1.im.guokr.com/UN8rjCVyebZgmUPv7hC-JysD_b1CbzmnDu5akgfgcfJYAgAAUAEAAEpQ.jpg","replies_count":1,"current_user_has_liked":false,"page_source":"http://jingxuan.guokr.com/pick/82889/?ad=1","author":"misssty","summary":"你面前有一盘香喷喷的披萨，而我面前则是寥寥几根小胡萝卜。我们的大脑开始迅速处理得到的信息\u2014\u2014然后我们会得出\u201c很好吃的样子呢\u201d和\u201c这","source":"group","reply_root_id":786387,"date_created":1.49334902E9},{"link_v2_sync_img":"http://jingxuan.guokr.com/pick/v2/82883/sync/","source_name":"天了噜！","video_url":"","current_user_has_collected":false,"likings_count":8,"images":["http://3.im.guokr.com/ykdMy88Tgf6-tTKPMGdUU4LQJ0S0b-kiX3xQp_T_eZ1dAgAA0wEAAEpQ.jpg?imageView2/1/w/480/h/370","http://2.im.guokr.com/iRbr1MSK1psAeCsj1cUkHOpUCvRXSX6Z_dZRZk8_k6VdAgAAdwMAAEpQ.jpg?imageView2/1/w/480/h/703","http://3.im.guokr.com/7cCnO84SKQLl1rPE5VGRcltT00B7myR5IoXWj-vdSfNdAgAAeQIAAEpQ.jpg?imageView2/1/w/480/h/502","http://2.im.guokr.com/ZmAkfxawwxH8CB3mb3wlVYIsGyf0VWxG_igaRvShSsVdAgAAMwIAAEpQ.jpg?imageView2/1/w/480/h/446"],"video_duration":null,"id":82883,"category":"health","style":"article","title":"这个女孩记得生命中每一个细节，全世界只有80人能做到","source_data":{"image":"http://2.im.guokr.com/r8PINb_RG_niPP_rsxxvHLK7HmQE9i1NZD6pWV_0VDKgAAAAoAAAAFBO.png?imageView2/1/w/160/h/160","summary":"吸走你的无聊时间！","id":52,"key":"天了噜！","title":"天了噜！"},"headline_img_tb":"http://3.im.guokr.com/ykdMy88Tgf6-tTKPMGdUU4LQJ0S0b-kiX3xQp_T_eZ1dAgAA0wEAAEpQ.jpg?imageView2/1/w/288/h/222","link_v2":"http://jingxuan.guokr.com/pick/v2/82883/","date_picked":1.49343846E9,"is_top":false,"link":"http://jingxuan.guokr.com/pick/82883/","headline_img":"http://3.im.guokr.com/ykdMy88Tgf6-tTKPMGdUU4LQJ0S0b-kiX3xQp_T_eZ1dAgAA0wEAAEpQ.jpg","replies_count":1,"current_user_has_liked":false,"page_source":"http://jingxuan.guokr.com/pick/82883/?ad=1","author":"秋水荻叶","summary":"你还能记得你第一个生日上的每一个细节吗？ 当然你不行了！但Rebecca Sharrock就可以。这位来自澳大利亚布里斯班的27岁","source":"group","reply_root_id":786327,"date_created":1.493288424E9},{"link_v2_sync_img":"http://jingxuan.guokr.com/pick/v2/82869/sync/","source_name":"天了噜！","video_url":"","current_user_has_collected":false,"likings_count":9,"images":["http://2.im.guokr.com/qFWvYccpIxhimoS8i7znQBLlarR6ML5xugtzPvv6LX0gAwAAwgEAAFBO.png?imageView2/1/w/480/h/270","http://1.im.guokr.com/lzTaWOvaUgLDvqKEJv1JdzEWARhzhABGIv3sDt2WwUFzAgAAYQEAAEdJ.gif?imageView2/1/w/480/h/270","http://2.im.guokr.com/sA_2QH-RqNTJhE60Fa3Bxuo1SdF3MXLohBAML9yMBsKAAgAAaAEAAEdJ.gif?imageView2/1/w/480/h/270","http://3.im.guokr.com/pBAh9E8RMwOS438jX2iOlZmstrr0fccxzVrQ23MrC3GAAgAAaAEAAEdJ.gif?imageView2/1/w/480/h/270","http://3.im.guokr.com/t5It_m-oiU0nkDZtwL6vEL0okSH32ZC4qjk51p-osmOAAgAAaAEAAEdJ.gif?imageView2/1/w/480/h/270","http://1.im.guokr.com/38-Yx3DD-eTVRmmulYZxT0C_afr1hejUaC3mrJb18R-AAgAAaAEAAEdJ.gif?imageView2/1/w/480/h/270"],"video_duration":null,"id":82869,"category":"game","style":"article","title":"这个为游戏+1s的Mod里，成步堂竟被真宵爆菊了......","source_data":{"image":"http://2.im.guokr.com/r8PINb_RG_niPP_rsxxvHLK7HmQE9i1NZD6pWV_0VDKgAAAAoAAAAFBO.png?imageView2/1/w/160/h/160","summary":"吸走你的无聊时间！","id":52,"key":"天了噜！","title":"天了噜！"},"headline_img_tb":"http://2.im.guokr.com/qFWvYccpIxhimoS8i7znQBLlarR6ML5xugtzPvv6LX0gAwAAwgEAAFBO.png?imageView2/1/w/288/h/162","link_v2":"http://jingxuan.guokr.com/pick/v2/82869/","date_picked":1.49343846E9,"is_top":false,"link":"http://jingxuan.guokr.com/pick/82869/","headline_img":"http://2.im.guokr.com/qFWvYccpIxhimoS8i7znQBLlarR6ML5xugtzPvv6LX0gAwAAwgEAAFBO.png?imageView2/1/w/640/h/480","replies_count":0,"current_user_has_liked":false,"page_source":"http://jingxuan.guokr.com/pick/82869/?ad=1","author":"娄大江","summary":"《终极漫画英雄VS卡普空3（Ultimate Marvel VS Capcom 3）》（下简称《终极》）最近在PC端上线，随即各种","source":"group","reply_root_id":786238,"date_created":1.49323041E9},{"link_v2_sync_img":"http://jingxuan.guokr.com/pick/v2/82895/sync/","source_name":"物种日历","video_url":"","current_user_has_collected":false,"likings_count":5,"images":["http://2.im.guokr.com/4P7TKXxeA5g0hyHJxnwMSw9z3snoImuuOHFf3lb6DgB1AwAAnQQAAEpQ.jpg?imageView2/1/w/480/h/640","http://2.im.guokr.com/QrRtrd26RWyU_tHiQ51w3AgDPzygbaA-eoAXwNA0ag-lAwAAvAIAAEpQ.jpg?imageView2/1/w/480/h/360","http://2.im.guokr.com/NpOvJofMKCghTe41zT8K7y_HdMWlkj_xVzP-sYFVZ-mKAgAAsAEAAEpQ.jpg?imageView2/1/w/480/h/319","http://2.im.guokr.com/fPJQgMJ1RWEBoBrq-7KdRRHUneu8XnZuTUe93z7IhyuKAgAApwEAAEpQ.jpg?imageView2/1/w/480/h/312","http://2.im.guokr.com/TtGm4okjxmCVsPYVtMd41d_VC9sbDt6_HRRncZejTwccAwAAvAIAAEpQ.jpg?imageView2/1/w/480/h/422","http://1.im.guokr.com/FpLFmrrO4Kx3P9pCkmuBvhPPOAPo_NEJOBqgOFcLyRWKAgAAsQEAAEpQ.jpg?imageView2/1/w/480/h/319","http://3.im.guokr.com/OOvjc0yYL4Dbj0cE6JXuJus3nfmgTX5aw5gfg4DyyHKKAgAAsgEAAEpQ.jpg?imageView2/1/w/480/h/320","http://1.im.guokr.com/1ijv98QtHVQvy8FS8a8EJDnfjorP2CNLi2Jo_eS_PNaABwAAOAQAAEpQ.jpg?imageView2/1/w/480/h/270","http://3.im.guokr.com/czBi9PB3iVnKwpbz8NdC0iuFLqyGX351_uuGi5PYV8xABgAAsAQAAEpQ.jpg?imageView2/1/w/480/h/360","http://3.im.guokr.com/WCHc89S3d-kEvED5UroilvX2yOYogUPMfXIQVTWH4vhABgAAsAQAAEpQ.jpg?imageView2/1/w/480/h/360","http://2.im.guokr.com/3BbUcOym1jG4NBp_hX0QyJBnVETewkyuOatTrDeTeL8GAwAAQQIAAEpQ.jpg?imageView2/1/w/480/h/357","http://1.im.guokr.com/5HsI6K3TewQ22Ap6CFSIUj7rX5VsQIetoSMBc1e6ExZABgAArwQAAEpQ.jpg?imageView2/1/w/480/h/359","http://1.im.guokr.com/ukQfjvrd51xfJV_fPMtHk9Zk_HphH65BocDVOHzWtsAgAwAAWAIAAEpQ.jpg?imageView2/1/w/480/h/360"],"video_duration":null,"id":82895,"category":"nature","style":"article","title":"珊瑚界的野蔷薇，向着光明，野蛮生长","source_data":{"image":"http://1.im.guokr.com/VvkCBwTkTvsNya95AjdtCjLCmXJTMiQEn5edxQrjBOLoAwAA6AMAAEpQ.jpg","summary":"每天一个物种，2016年，物种日历带你探索餐桌上的一切。","id":5,"key":"物种日历","title":"物种日历"},"headline_img_tb":"http://2.im.guokr.com/NpOvJofMKCghTe41zT8K7y_HdMWlkj_xVzP-sYFVZ-mKAgAAsAEAAEpQ.jpg?imageView2/1/w/288/h/191","link_v2":"http://jingxuan.guokr.com/pick/v2/82895/","date_picked":1.4934384E9,"is_top":false,"link":"http://jingxuan.guokr.com/pick/82895/","headline_img":"http://2.im.guokr.com/NpOvJofMKCghTe41zT8K7y_HdMWlkj_xVzP-sYFVZ-mKAgAAsAEAAEpQ.jpg?imageView2/1/w/640/h/480","replies_count":6,"current_user_has_liked":false,"page_source":"http://jingxuan.guokr.com/pick/82895/?ad=1","author":"千野youko","summary":"这次介绍的是一类名字好听，却长得相当自由奔放、不拘一格的珊瑚\u2014\u2014 蔷薇珊瑚属 Montipora 。属名来源于mons与porus","source":"group","reply_root_id":756357,"date_created":1.493395201E9},{"link_v2_sync_img":"http://jingxuan.guokr.com/pick/v2/82896/sync/","source_name":"心事鉴定组","video_url":"","current_user_has_collected":false,"likings_count":5,"images":["http://1.im.guokr.com/wxyzxB3gBZ3dOLr5ha9Kgjz4_AWdC0-WEQdLTxrc340CBgAA7wIAAEpQ.jpg?imageView2/1/w/555/h/271","http://2.im.guokr.com/IQDTAIuZwqasy-3xtq6Qn-x14ksUXg1jX_G2N1rrAxzcBQAAlgUAAEpQ.jpg?imageView2/1/w/555/h/529","http://2.im.guokr.com/fuNVC4XqB23Ym-3zRR4y-7YW8NPcx-m5_HIuFGysc4rcBQAA0AUAAEpQ.jpg?imageView2/1/w/555/h/550","http://3.im.guokr.com/L5D40pjvyuZvoKJ-J5ijcSXx-KiuITsZY_XY1XMC3WBQAwAANQIAAEpQ.jpg?imageView2/1/w/555/h/369","http://1.im.guokr.com/8cKuNCidf_upXD27HZzrtzta6e_LxY66z7-F90bRWOhPAwAANQIAAEpQ.jpg?imageView2/1/w/555/h/370"],"video_duration":null,"id":82896,"category":"humanities","style":"article","title":"为什么大城市里的人不急着结婚生娃？因为人太多啊","source_data":{"image":"http://2.im.guokr.com/OxAFxzG5wiLPjq4uaXLf8rIn7fCRgiaFKucYBbnUz_C2AAAAvAAAAFBO.png","title":"科学人","id":"10","key":"科学人","summary":"科研最新进展，学术最新动态，顶级学者的思考和见解。"},"headline_img_tb":"http://3.im.guokr.com/T_zYJv14Ji5jHAl356yHIKQVs7RCN2HDPPwo6a29podKAQAA3AAAAEpQ.jpg?imageView2/1/w/288/h/192","link_v2":"http://jingxuan.guokr.com/pick/v2/82896/","date_picked":1.4934384E9,"is_top":false,"link":"http://jingxuan.guokr.com/pick/82896/","headline_img":"http://3.im.guokr.com/T_zYJv14Ji5jHAl356yHIKQVs7RCN2HDPPwo6a29podKAQAA3AAAAEpQ.jpg","replies_count":8,"current_user_has_liked":false,"page_source":"http://jingxuan.guokr.com/pick/82896/?ad=1","author":"李子李子短信","summary":"或许在大城市生活的\u201c北漂\u201d\u201c沪漂\u201d们，最不理解的就是老家亲戚的\u201c猴急\u201d：什么时候结婚啊，都25了还没男/女朋友；怎么28了还不生娃","source":"minisite","reply_root_id":442137,"date_created":1.493371244E9},{"link_v2_sync_img":"http://jingxuan.guokr.com/pick/v2/82891/sync/","source_name":"天了噜！","video_url":"","current_user_has_collected":false,"likings_count":6,"images":["http://2.im.guokr.com/AfW_5iZezAweMcTi__8Hl9Q7bIeCnPE75lBXnSpwyMKwAAAAYAAAAEdJ.gif","http://1.im.guokr.com/zu6mtWcvv3othsQ1aCl9rsRu52em182cGI1L1XY_w0GwAAAAYAAAAEdJ.gif","http://3.im.guokr.com/J0hoKQ3jGi2jDMqT0D8W9l6oieNUr2WQo_DVvOXck5SwAAAAYAAAAEdJ.gif","http://1.im.guokr.com/5RZwnJ0ae4CVgkpzQPcyv7gL7RubGF3Xr1uYW2uxQBMyAQAAeQEAAEpQ.jpg","http://2.im.guokr.com/cN5y0U6QqHEu0wgCiEtSuq_RBzyIN8Cbxsg8eGXWsLB6AgAAaQEAAEpQ.jpg?imageView2/1/w/480/h/273","http://1.im.guokr.com/rA0Lpeosn1uD5vGpSS2LQZVTZLltyn4A2VI9Kgiqpp4yAQAAeQEAAEpQ.jpg","http://3.im.guokr.com/ytitOYprGtCMiDWRlXr5wW9y6diUDqLmWUc7VFdqLwCwAAAAYAAAAEdJ.gif","http://2.im.guokr.com/HQrXqyg0JVkbyx1ZZkx2_adOBdS3U5mr6UEG0hOZGAh6AgAAawEAAEpQ.jpg?imageView2/1/w/480/h/274","http://3.im.guokr.com/DUZD6KpWVgcw3dKUwvIBLOEKdyzHYjepcaV5Q5-JilYyAQAAdAEAAEpQ.jpg","http://3.im.guokr.com/93XHPiGRrNsI4jDPwxHLJ_JqmFmzGsrsB0oSztGu8stOAgAAiAAAAFBO.png?imageView2/1/w/480/h/110","http://3.im.guokr.com/Pie1MdPDRTHHTmw-NwtsysQcc5siyb8aca73Jj7V3VFQAgAAggAAAFBO.png?imageView2/1/w/480/h/105","http://2.im.guokr.com/b2SpuE05K4bNs72mMkchaeH9cpB8M4GdEXr6vKGrQlxGAgAAcAAAAFBO.png?imageView2/1/w/480/h/92","http://2.im.guokr.com/KCsnrwMudrK9iXq2lBRCaqk3W80gjukiDxkttg5g0T5BAgAAZAAAAFBO.png?imageView2/1/w/480/h/83"],"video_duration":null,"id":82891,"category":"gossip","style":"article","title":"当孕妇请求帮助时，围观群众竟然拒绝了？","source_data":{"image":"http://2.im.guokr.com/r8PINb_RG_niPP_rsxxvHLK7HmQE9i1NZD6pWV_0VDKgAAAAoAAAAFBO.png?imageView2/1/w/160/h/160","summary":"吸走你的无聊时间！","id":52,"key":"天了噜！","title":"天了噜！"},"headline_img_tb":"http://2.im.guokr.com/cN5y0U6QqHEu0wgCiEtSuq_RBzyIN8Cbxsg8eGXWsLB6AgAAaQEAAEpQ.jpg?imageView2/1/w/288/h/163","link_v2":"http://jingxuan.guokr.com/pick/v2/82891/","date_picked":1.4934384E9,"is_top":false,"link":"http://jingxuan.guokr.com/pick/82891/","headline_img":"http://2.im.guokr.com/cN5y0U6QqHEu0wgCiEtSuq_RBzyIN8Cbxsg8eGXWsLB6AgAAaQEAAEpQ.jpg","replies_count":3,"current_user_has_liked":false,"page_source":"http://jingxuan.guokr.com/pick/82891/?ad=1","author":"桑小苜","summary":"助人为乐是中华民族的传统美德，特别是帮助老弱病残孕\u2026\u2026 所以说，当大街上一位孕妇向你寻求帮助时你会怎么做？ 可是，如果这个请求我们","source":"group","reply_root_id":786332,"date_created":1.493289914E9},{"link_v2_sync_img":"http://jingxuan.guokr.com/pick/v2/82892/sync/","source_name":"天了噜！","video_url":"","current_user_has_collected":false,"likings_count":15,"images":["http://1.im.guokr.com/E8aonSi4KFyNZNx-ZGRGwpXIBImuPl4xUTEOFAmS2zPEAAAAfgAAAEpQ.jpg","http://2.im.guokr.com/QTT_p0k7bVa15NVkLqg9gyk2ukwiysY8NY2_oDygFDt6AgAApgEAAEpQ.jpg?imageView2/1/w/480/h/319","http://1.im.guokr.com/RHUO7ICx9ozjgXFHzmvJr_--Cm5IzXR0GIj4jh3VJ_97AgAAyQEAAFBO.png?imageView2/1/w/480/h/345","http://1.im.guokr.com/OzIWODr21tdopmncLvTyYF3VpyuoIY1YcTT67WRQYNF8AgAA3gEAAFBO.png?imageView2/1/w/480/h/360","http://2.im.guokr.com/LT3f3wYVWgT_24bPhVzFvL404lVwVztJBMOwIJmdI916AgAArQEAAEpQ.jpg?imageView2/1/w/480/h/324","http://2.im.guokr.com/EhaUggKnJVnUZVqdtPQqGx_qt2B4mOves8Q2csYoEht5AgAAbgAAAFBO.png?imageView2/1/w/480/h/83","http://2.im.guokr.com/r7ClMPwuxAEm1IcEC7wKjL6NvUjLq2Zr1f7Kq42N_gt8AgAAfwAAAFBO.png?imageView2/1/w/480/h/95","http://2.im.guokr.com/5HVVRGCx9qaC2cRVH544Vw2mMcbKRa_8nn9ZQoQd2G97AgAA1gAAAFBO.png?imageView2/1/w/480/h/161"],"video_duration":null,"id":82892,"category":"gossip","style":"article","title":"母女被关桑拿房90分钟致死！真是死神来了？","source_data":{"image":"http://2.im.guokr.com/r8PINb_RG_niPP_rsxxvHLK7HmQE9i1NZD6pWV_0VDKgAAAAoAAAAFBO.png?imageView2/1/w/160/h/160","summary":"吸走你的无聊时间！","id":52,"key":"天了噜！","title":"天了噜！"},"headline_img_tb":"http://2.im.guokr.com/QTT_p0k7bVa15NVkLqg9gyk2ukwiysY8NY2_oDygFDt6AgAApgEAAEpQ.jpg?imageView2/1/w/288/h/191","link_v2":"http://jingxuan.guokr.com/pick/v2/82892/","date_picked":1.4934384E9,"is_top":false,"link":"http://jingxuan.guokr.com/pick/82892/","headline_img":"http://2.im.guokr.com/QTT_p0k7bVa15NVkLqg9gyk2ukwiysY8NY2_oDygFDt6AgAApgEAAEpQ.jpg","replies_count":0,"current_user_has_liked":false,"page_source":"http://jingxuan.guokr.com/pick/82892/?ad=1","author":"鱼尾何","summary":"国外的媒体最近报道了一个骇人听闻的事情 一对母女被困在桑拿房90分钟 当救援人员破门而入的时候，母女俩已经死亡 是不是有点像死神来","source":"group","reply_root_id":786331,"date_created":1.493289767E9},{"link_v2_sync_img":"http://jingxuan.guokr.com/pick/v2/82864/sync/","source_name":"天了噜！","video_url":"","current_user_has_collected":false,"likings_count":9,"images":["http://2.im.guokr.com/EW74v7aWVoiNwMARl3Fs1JdBbHJ_S-xP9cDtGupDgS8JAwAAogEAAFBO.png?imageView2/1/w/480/h/258","http://1.im.guokr.com/S5I5CfiKotyBYe9Qij3wfE-bDk-2eWFRci-CNqBmMn22AgAAfwEAAEpQ.jpg?imageView2/1/w/480/h/264","http://1.im.guokr.com/M8uueYDpzHxearPObKcRgXmjf4Hr3CfQ9yjSNaX5bJ6QAQAA4QAAAEdJ.gif","http://2.im.guokr.com/54cnZuJz6VcptfyEKL-D1GPWAsEQBThocJuWGUHaFdSQAQAA4QAAAEdJ.gif","http://2.im.guokr.com/YbGYh0yS1kBq_HaYgTNDSVDz4hi00AGYpRtr5_Ywmz2QAQAA4QAAAEdJ.gif","http://1.im.guokr.com/hkckJTQDsOhpU1CF4bzAElhEjjAcyDjElEgdZpLV1oGQAQAA4QAAAEdJ.gif","http://1.im.guokr.com/_Uq7ubir-QRp4HlMJm-KAPif75diB3FJ1vAGTnLaysuQAQAA4QAAAEdJ.gif","http://3.im.guokr.com/JS9IfAdZMuDz6iobu4pz5FEZc8z-UA1uO1dPlACl6WCQAQAA4QAAAEdJ.gif","http://1.im.guokr.com/el2RQhuk2Fo1afXG4lcZ4TFKuC_lnJ72BQ5sGKCmJRWQAQAA4QAAAEdJ.gif","http://3.im.guokr.com/aQFxJ_Nk21cZqGTKTUc6yuwmAxWU3zNEIi0qU9fVyYeQAQAA4QAAAEdJ.gif","http://3.im.guokr.com/fPaFm6aTjni4BQgbveMPBWVNGxouvERKF1PPpIHMbuT4AQAAcAAAAFBO.png?imageView2/1/w/480/h/106","http://3.im.guokr.com/XX4_yAyfimpLClCRhsWWOBMeNb3daPbAdjMKd6PiHGgSAwAATgAAAFBO.png?imageView2/1/w/480/h/47","http://1.im.guokr.com/VQuH_Vp7mvodiBTfDpYnwM80Q1A6MaL2oZSSkXrYOmKrAQAAGgEAAFBO.png","http://3.im.guokr.com/qJZ6uZN8yW0bYTrIvIFGFFf_HlPpudGFYj4tJuj7Bzx7BAAAmgIAAFBO.png?imageView2/1/w/480/h/278","http://2.im.guokr.com/XNUABCK0tHopr66XpE8lf7g6Yq-3fgHQqlC0o___89f6BAAAvgIAAFBO.png?imageView2/1/w/480/h/264","http://2.im.guokr.com/u8YktnaMmP964XZtCyisrREjTcPniPejSQ9ENkHfwJD2BAAAlwIAAFBO.png?imageView2/1/w/480/h/250","http://3.im.guokr.com/p7mUGAwk2tzEsQoUrXWoa7L7dnbyUoJapK2kqTYEqpuQAQAA4QAAAEdJ.gif","http://3.im.guokr.com/m5Oa2fSy-Ezem_oI8sP9sr3ZoGaNLaXYQF2PSxfmOleQAQAA4QAAAEdJ.gif","http://3.im.guokr.com/JD-1uKgkFbxUky2GyU7LZnKOYDDiX6y2N6czPM2WWRWQAQAA4QAAAEdJ.gif","http://2.im.guokr.com/Lz8OKv6LdXMJCZ7527bp5UKbAK91JESByL_lIqApLFiQAQAA4QAAAEdJ.gif","http://1.im.guokr.com/f2Ia80Jc3Otsq4I9cno7GHd9tABBKx_BOxvDoEaVPCOQAQAA4QAAAEdJ.gif","http://3.im.guokr.com/be3p5sTmD9VaYqjEhouJ2saY51OGfKZXKEYNfy0DkauyAQAAVQAAAFBO.png","http://3.im.guokr.com/qhCeR730ZRDZfAYo9PAJOGyqqaixlpLAQ0kIIGd0pY8lAgAAaAAAAFBO.png?imageView2/1/w/480/h/90","http://2.im.guokr.com/RIuT1vWh9bMrrkCeAc-v1iNGmq-_sGD4dXcduKFH6Y2YAQAAeAAAAFBO.png"],"video_duration":null,"id":82864,"category":"funny","style":"article","title":"爆红油管！这个大叔靠一把刀做出顶级野炊美食！","source_data":{"image":"http://2.im.guokr.com/r8PINb_RG_niPP_rsxxvHLK7HmQE9i1NZD6pWV_0VDKgAAAAoAAAAFBO.png?imageView2/1/w/160/h/160","summary":"吸走你的无聊时间！","id":52,"key":"天了噜！","title":"天了噜！"},"headline_img_tb":"http://1.im.guokr.com/S5I5CfiKotyBYe9Qij3wfE-bDk-2eWFRci-CNqBmMn22AgAAfwEAAEpQ.jpg?imageView2/1/w/288/h/158","link_v2":"http://jingxuan.guokr.com/pick/v2/82864/","date_picked":1.4934384E9,"is_top":false,"link":"http://jingxuan.guokr.com/pick/82864/","headline_img":"http://1.im.guokr.com/S5I5CfiKotyBYe9Qij3wfE-bDk-2eWFRci-CNqBmMn22AgAAfwEAAEpQ.jpg?imageView2/1/w/640/h/480","replies_count":3,"current_user_has_liked":false,"page_source":"http://jingxuan.guokr.com/pick/82864/?ad=1","author":"花生卷i","summary":"嘿！朋友，你野炊过吗？在野外，不好控制火候也没有趁手的器具食材，做出来的食物往往是外表漆黑，内部血生生，像这样\u2026\u2026 但是这世上就是","source":"group","reply_root_id":786328,"date_created":1.493288593E9},{"link_v2_sync_img":"http://jingxuan.guokr.com/pick/v2/82890/sync/","source_name":"天了噜！","video_url":"","current_user_has_collected":false,"likings_count":15,"images":["http://3.im.guokr.com/ludT7kLcBAPrarnWOUbBfoGhE7Smrol9baJBSHeo3vR8AQAA2gAAAEdJ.gif","http://1.im.guokr.com/g1d99633VNy3l40JyhfgNz0DxfmqwJXxhxgfFyjLD99oAQAA7QAAAEdJ.gif","http://1.im.guokr.com/wEan7LXo90kg4m6vBvCz75guGai5uSsW0OGwfJ5Bn8l8AQAA2gAAAEdJ.gif","http://3.im.guokr.com/ZVTYD0hqSgFkj6qNNngiHXHJx69AdNkFCDyzeOFs1gN8AQAA2gAAAEdJ.gif","http://3.im.guokr.com/xWnTO2QKT2U2NC8j5Q8b5kSf505jEmx8e8edkGIMU7T_AwAAWgIAAFBO.png?imageView2/1/w/480/h/282","http://1.im.guokr.com/k79sxYmNHfOGeHPzYvqgwAnGUKodDSZxub681ofLwS58AQAA5wAAAEdJ.gif","http://1.im.guokr.com/N3kM36lNwn6t5yK8RzwF61Oy5jCh3ZeX4TYu9Sei4eCGAgAAXQEAAEpQ.jpg?imageView2/1/w/480/h/259","http://3.im.guokr.com/PN7qJp9kV_5szaboEuSfl70BvtvRd5G_YqCbI9bWR1N8AgAArQEAAEpQ.jpg?imageView2/1/w/480/h/323","http://2.im.guokr.com/blufeG7flE0Ve1h5FKetrw-u0e4TfV1RN_u4_qxiePl8AQAA2wAAAEdJ.gif"],"video_duration":null,"id":82890,"category":"funny","style":"article","title":"塑料瓶可以修桥，还能造船！","source_data":{"image":"http://2.im.guokr.com/r8PINb_RG_niPP_rsxxvHLK7HmQE9i1NZD6pWV_0VDKgAAAAoAAAAFBO.png?imageView2/1/w/160/h/160","summary":"吸走你的无聊时间！","id":52,"key":"天了噜！","title":"天了噜！"},"headline_img_tb":"http://3.im.guokr.com/PN7qJp9kV_5szaboEuSfl70BvtvRd5G_YqCbI9bWR1N8AgAArQEAAEpQ.jpg?imageView2/1/w/288/h/194","link_v2":"http://jingxuan.guokr.com/pick/v2/82890/","date_picked":1.4934384E9,"is_top":false,"link":"http://jingxuan.guokr.com/pick/82890/","headline_img":"http://3.im.guokr.com/PN7qJp9kV_5szaboEuSfl70BvtvRd5G_YqCbI9bWR1N8AgAArQEAAEpQ.jpg","replies_count":5,"current_user_has_liked":false,"page_source":"http://jingxuan.guokr.com/pick/82890/?ad=1","author":"ApoE","summary":"饮料瓶可以做什么？它能搭起一座小桥！这可不是摆设，人真的可以在上面走哦： 这些塑料瓶还可以用来做成椅子： 桌椅全套也没问题，坐下来","source":"group","reply_root_id":786293,"date_created":1.493271945E9},{"link_v2_sync_img":"http://jingxuan.guokr.com/pick/v2/82882/sync/","source_name":"天了噜！","video_url":"","current_user_has_collected":false,"likings_count":10,"images":["http://1.im.guokr.com/DJp0INHQekkz74NtHBTsknq7x9Vk8zWWWQl6K8hKQ-C8AgAAOQUAAEpQ.jpg?imageView2/1/w/480/h/916","http://2.im.guokr.com/BYZSDHiH_nSzVNnno3pg7Z8FOUzDpcrzpfLtsQiS5YO8AgAAuwEAAEpQ.jpg?imageView2/1/w/480/h/303","http://3.im.guokr.com/cczaw0tlaoceNkBiqkhWDuwjVkYyBzBB-N4Y4UwVk5W8AgAA5AEAAEpQ.jpg?imageView2/1/w/480/h/331","http://2.im.guokr.com/2TLuaGEb4gsxYeEFafFogGcNNH4-mbP9PyjsbpzxdKO8AgAAewEAAEpQ.jpg?imageView2/1/w/480/h/259","http://1.im.guokr.com/p7GjwlIHJwevLv6j7QwC1q1Ic0M14N-jaBC-yzdEYxm8AgAAigIAAEpQ.jpg?imageView2/1/w/480/h/445","http://1.im.guokr.com/8skpxOBmhoOWAZsZB4PMu5-4dUGmcsNTTVL78G25gd28AgAAKgIAAEpQ.jpg?imageView2/1/w/480/h/379","http://2.im.guokr.com/SeyHDrh-ObKvfqu0AQFDTuiTki_Djf5eaIoatVPL3S-8AgAAiQMAAEpQ.jpg?imageView2/1/w/480/h/620","http://1.im.guokr.com/ZiN9WtFavYFy43m9dKTnKc236OCYGrCcsQDMYfLTcS28AgAAIAMAAEpQ.jpg?imageView2/1/w/480/h/548","http://2.im.guokr.com/qPYij6HIlbR-GPsLZQ_6A8SrlO3yeKhbEx_zzp0b0168AgAAOAMAAEpQ.jpg?imageView2/1/w/480/h/565","http://2.im.guokr.com/AWf1i68wahgO50VBfdv8JOzJBKqbFdLlmSGNKAHTFp28AgAADQIAAEpQ.jpg?imageView2/1/w/480/h/360","http://1.im.guokr.com/9L_DicQL-tnpm_Qyx7tt894m7-orEhyDfEwJypPvb628AgAAGQQAAEpQ.jpg?imageView2/1/w/480/h/719","http://3.im.guokr.com/ztCFGQUEQ6hasq7TfAllxQozGY-oQpbqgDmo7FEnqdi8AgAAbQIAAEpQ.jpg?imageView2/1/w/480/h/425","http://3.im.guokr.com/7K6Hp07oS0jYkEVUJCPUdcamk6tjJZKim9gs0JMRNDC8AgAA0wEAAEpQ.jpg?imageView2/1/w/480/h/320","http://3.im.guokr.com/W_yFCQn331VAW1Scaliec-OwnPA-cW2l7SM-qIDe8ZK8AgAAmwMAAEpQ.jpg?imageView2/1/w/480/h/632","http://2.im.guokr.com/i6tW3h3i1y1GEAD8Q2nRkNDRPeAXzMc3CDSrQQujloG8AgAA0wEAAEpQ.jpg?imageView2/1/w/480/h/320"],"video_duration":null,"id":82882,"category":"funny","style":"article","title":"来，见识一下这些动物界摇滚重金属党。。","source_data":{"image":"http://2.im.guokr.com/r8PINb_RG_niPP_rsxxvHLK7HmQE9i1NZD6pWV_0VDKgAAAAoAAAAFBO.png?imageView2/1/w/160/h/160","summary":"吸走你的无聊时间！","id":52,"key":"天了噜！","title":"天了噜！"},"headline_img_tb":"http://1.im.guokr.com/DJp0INHQekkz74NtHBTsknq7x9Vk8zWWWQl6K8hKQ-C8AgAAOQUAAEpQ.jpg?imageView2/1/w/288/h/550","link_v2":"http://jingxuan.guokr.com/pick/v2/82882/","date_picked":1.4934384E9,"is_top":false,"link":"http://jingxuan.guokr.com/pick/82882/","headline_img":"http://1.im.guokr.com/DJp0INHQekkz74NtHBTsknq7x9Vk8zWWWQl6K8hKQ-C8AgAAOQUAAEpQ.jpg?imageView2/1/w/640/h/480","replies_count":5,"current_user_has_liked":false,"page_source":"http://jingxuan.guokr.com/pick/82882/?ad=1","author":"秋水荻叶","summary":"你也许自诩为终极重金属党，但在这些动物界硬核份子面前，可能会败下阵来。他们是如此地酷炫前卫，让你简直想要跟着一起摇头晃脑、摇滚起来","source":"group","reply_root_id":786269,"date_created":1.493260436E9},{"link_v2_sync_img":"http://jingxuan.guokr.com/pick/v2/82885/sync/","source_name":"天了噜！","video_url":"","current_user_has_collected":false,"likings_count":5,"images":["http://1.im.guokr.com/WZg0VjE8R7wNTR4QgncPvIaTTgbhupn1-ZzLxeCZerAVAQAAugAAAEdJ.gif","http://3.im.guokr.com/hCIZsTPn-xpJJXeE-mVyc98UCvVkxen_eGi8sVsoLsgiAQAAwAAAAEdJ.gif","http://3.im.guokr.com/FudZ9MI3ZpTjtTnpzAB0KbdcILXT8DlYNvkFUPb5NgD0AAAAswAAAEdJ.gif","http://2.im.guokr.com/r6uz2c-2NUoIo8KugDcIpq_vcNUUCoxAHG1jmLNUqQ03AQAA4gAAAEdJ.gif","http://1.im.guokr.com/8ElL-6nFSx4zwZogbnwokXp4sa6OqBXOavu5rYC_CIkXAQAA0wAAAEdJ.gif","http://2.im.guokr.com/aWhpzfQ8iSPdF_lbcj7C2oJPtdPcVzzzh43SAgddqQRLAQAAwwAAAEdJ.gif"],"video_duration":null,"id":82885,"category":"funny","style":"article","title":"蜜汁快感：戳破气球的N种方式！","source_data":{"image":"http://2.im.guokr.com/r8PINb_RG_niPP_rsxxvHLK7HmQE9i1NZD6pWV_0VDKgAAAAoAAAAFBO.png?imageView2/1/w/160/h/160","summary":"吸走你的无聊时间！","id":52,"key":"天了噜！","title":"天了噜！"},"headline_img_tb":"http://2.im.guokr.com/QKip10xq7rSgTB41lAKo0x2k4gSWV1eiGfi8-MsdPQToAwAAmgIAAEpQ.jpg?imageView2/1/w/288/h/191","link_v2":"http://jingxuan.guokr.com/pick/v2/82885/","date_picked":1.4934384E9,"is_top":false,"link":"http://jingxuan.guokr.com/pick/82885/","headline_img":"http://2.im.guokr.com/QKip10xq7rSgTB41lAKo0x2k4gSWV1eiGfi8-MsdPQToAwAAmgIAAEpQ.jpg?imageView2/1/w/640/h/480","replies_count":1,"current_user_has_liked":false,"page_source":"http://jingxuan.guokr.com/pick/82885/?ad=1","author":"医学生萌小潮","summary":"气球是我们生活中常见的小玩意儿，故意把气球弄破也是非常常见的恶作剧手法，而最近脑洞大开的歪果仁们又把气球玩出了新花样，一起来看一下","source":"group","reply_root_id":786214,"date_created":1.493215479E9},{"link_v2_sync_img":"http://jingxuan.guokr.com/pick/v2/82884/sync/","source_name":"天了噜！","video_url":"","current_user_has_collected":false,"likings_count":15,"images":["http://3.im.guokr.com/7Sn9H24wddJQrd4oqVH_Z3W63FafsbZe1KwTsdACrYKWAgAAXgEAAEpQ.jpg?imageView2/1/w/480/h/253","http://2.im.guokr.com/lkjp50Fc6cQWfexy-gRaVCZ0bq2l9bP397kQrCGkB7WUAgAA8QAAAEpQ.jpg?imageView2/1/w/480/h/175"],"video_duration":null,"id":82884,"category":"science","style":"article","title":"3D打印又有了新原料！它就是\u2014\u2014土\u2026\u2026","source_data":{"image":"http://2.im.guokr.com/r8PINb_RG_niPP_rsxxvHLK7HmQE9i1NZD6pWV_0VDKgAAAAoAAAAFBO.png?imageView2/1/w/160/h/160","summary":"吸走你的无聊时间！","id":52,"key":"天了噜！","title":"天了噜！"},"headline_img_tb":"http://3.im.guokr.com/7Sn9H24wddJQrd4oqVH_Z3W63FafsbZe1KwTsdACrYKWAgAAXgEAAEpQ.jpg?imageView2/1/w/288/h/152","link_v2":"http://jingxuan.guokr.com/pick/v2/82884/","date_picked":1.4934384E9,"is_top":false,"link":"http://jingxuan.guokr.com/pick/82884/","headline_img":"http://3.im.guokr.com/7Sn9H24wddJQrd4oqVH_Z3W63FafsbZe1KwTsdACrYKWAgAAXgEAAEpQ.jpg?imageView2/1/w/640/h/480","replies_count":0,"current_user_has_liked":false,"page_source":"http://jingxuan.guokr.com/pick/82884/?ad=1","author":"ApoE","summary":"这几年3D打印这概念可以说是火得不行，3D打印机们打印的东西也是花样百出：塑料大概是最常见的了，还有的能打印金属、玻璃、巧克力，甚","source":"group","reply_root_id":786204,"date_created":1.493207704E9},{"link_v2_sync_img":"http://jingxuan.guokr.com/pick/v2/82862/sync/","source_name":"天了噜！","video_url":"","current_user_has_collected":false,"likings_count":5,"images":["http://3.im.guokr.com/bVyjHXJxZvQQCGFJZKe84c5Zf7ZU1dwIY6h1gE7vEROnBQAAHQMAAFBO.png?imageView2/1/w/480/h/264","http://3.im.guokr.com/GVM1gi9O6OOcqvkPT3GYF2QS0jtXZ7ic_RndyFOlpQTKAwAAQgUAAEpQ.jpg?imageView2/1/w/480/h/666","http://1.im.guokr.com/6qPe0R7eMQfNKTBEh8KKhIhnA4G6ixskaA7Lly9J1xcJBQAAdQMAAFBO.png?imageView2/1/w/480/h/329","http://2.im.guokr.com/mv7Nz0paj0cmXo5M8Uu6RWBTbzNrRknMo_LmiO0r51PLBAAA8QEAAFBO.png?imageView2/1/w/480/h/194","http://2.im.guokr.com/ZVPDfhvKHTDPEhnQln64HmUsBCbEq89KtJVKh2bqjC5wBAAAhgMAAFBO.png?imageView2/1/w/480/h/381","http://2.im.guokr.com/8tSrQEPUOEXkUqIE9EqbUfbzFBe7Rd3sWCPP5kyjSQfkAgAA5wIAAFBO.png?imageView2/1/w/480/h/481","http://2.im.guokr.com/XhS6sEN2aIB6fJ7x2vAdBbxg5Heil1Y1-4M8Y1WIUI3gAgAAHgIAAFBO.png?imageView2/1/w/480/h/353","http://3.im.guokr.com/pVWkJ-PKOWqc3ppIE300Cq7rQwnoR0DzUFaFoO5knnLZAgAA8QEAAFBO.png?imageView2/1/w/480/h/327","http://3.im.guokr.com/JAgH2upTpHYOl4A3vxoA4Jbq-ErchX4vceZgwNt3G-3cAgAAdQIAAFBO.png?imageView2/1/w/480/h/412","http://2.im.guokr.com/MIjD7Hua4HCVwHM9s19ZUuKuf-YRibLpyhNbAGI45y3hAgAAAAIAAFBO.png?imageView2/1/w/480/h/333","http://1.im.guokr.com/teq7fdxaLO-1oRUCUxKzat20_cPssXsMZaFbp416iHTfAgAAFwIAAFBO.png?imageView2/1/w/480/h/349","http://3.im.guokr.com/oHRuNtH6EoAkEp1HJy5k6SkIA7YS9Csd-2BirfAhW5DhAgAA6AEAAFBO.png?imageView2/1/w/480/h/317","http://1.im.guokr.com/ZNkrdPahgOtpXrMrAGZ5ARdldmhGAwch805_w3Hdvr6tAQAAJAEAAEpQ.jpg","http://3.im.guokr.com/3AGXMfg7jeYZrUAIBot8KhgAG1m4r2oKDGUCyQpYoN_dAgAAwQIAAFBO.png?imageView2/1/w/480/h/461","http://1.im.guokr.com/s6JsDTSfavxArYoM5Z1HUIgh85qg1Ux50eIFw736fz_fAgAA7AEAAFBO.png?imageView2/1/w/480/h/321","http://1.im.guokr.com/uegwZK4xxkHybHlcODHa6ft3x5txuvcbMK9TLEUVA8HeAgAAGgIAAFBO.png?imageView2/1/w/480/h/351","http://2.im.guokr.com/ywvknOYzAaUBUBr0Emcos0hej-LEUGNb65uRF6hh8JdaAgAAewEAAFBO.png?imageView2/1/w/480/h/302","http://2.im.guokr.com/9n1o-qqYgrk3V9RQgcz5_tkeBXG6W0aw9UnVBcyK9qKABwAAtQMAAFBO.png?imageView2/1/w/480/h/237"],"video_duration":null,"id":82862,"category":"humanities","style":"article","title":"贺柯南发售两亿册！下一个犯人，可能就是你？！","source_data":{"image":"http://2.im.guokr.com/r8PINb_RG_niPP_rsxxvHLK7HmQE9i1NZD6pWV_0VDKgAAAAoAAAAFBO.png?imageView2/1/w/160/h/160","summary":"吸走你的无聊时间！","id":52,"key":"天了噜！","title":"天了噜！"},"headline_img_tb":"http://2.im.guokr.com/9n1o-qqYgrk3V9RQgcz5_tkeBXG6W0aw9UnVBcyK9qKABwAAtQMAAFBO.png?imageView2/1/w/288/h/142","link_v2":"http://jingxuan.guokr.com/pick/v2/82862/","date_picked":1.49342406E9,"is_top":false,"link":"http://jingxuan.guokr.com/pick/82862/","headline_img":"http://2.im.guokr.com/9n1o-qqYgrk3V9RQgcz5_tkeBXG6W0aw9UnVBcyK9qKABwAAtQMAAFBO.png?imageView2/1/w/640/h/480","replies_count":13,"current_user_has_liked":false,"page_source":"http://jingxuan.guokr.com/pick/82862/?ad=1","author":"雨樱嘤嘤嘤","summary":"由青山刚昌老师创作的推理漫画《名侦探柯南》于1994年起在日本小学馆的漫画杂志《周刊少年Sunday》上开始连载，漫画连载已有99","source":"group","reply_root_id":786317,"date_created":1.493282885E9}]
     */

    @SerializedName("now")
    private String now;
    @SerializedName("ok")
    private boolean ok;
    @SerializedName("result")
    private List<ResultBean> result;

    public String getNow() {
        return now;
    }

    public void setNow(String now) {
        this.now = now;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "GuokrNewsBean{" +
                "now='" + now + '\'' +
                ", ok=" + ok +
                ", result=" + result +
                '}';
    }

    public static class ResultBean {
        /**
         * link_v2_sync_img : http://jingxuan.guokr.com/pick/v2/82897/sync/
         * source_name : 天了噜！
         * video_url :
         * current_user_has_collected : false
         * likings_count : 7
         * images : ["http://1.im.guokr.com/eZob3HShd7w3lYGU7TWcCin6iJiGodALtCje1aK4TPAFAgAAHwEAAFBO.png?imageView2/1/w/480/h/266","http://3.im.guokr.com/W38qHMO8FpmkN_fa0yZvAUld7AP45ugG9d59AKAaKn4BAgAAHwEAAFBO.png?imageView2/1/w/480/h/268","http://1.im.guokr.com/Oyj-wX07Fx3DW-xAiXAw_iP3d2Hm349Z-5YJAr_x95H8AQAAPwEAAFBO.png?imageView2/1/w/480/h/301","http://1.im.guokr.com/iGCV9eT3Klm9ropPNDqiIX9A0agNlB7rvx5x-WGm6FTjAQAACwEAAFBO.png?imageView2/1/w/480/h/265","http://3.im.guokr.com/ZgfSP8jvYv5YFqJZIop0zNuNNFnT7pNKS0XUAUoEdSL_AQAAHQEAAFBO.png?imageView2/1/w/480/h/267","http://2.im.guokr.com/7K6mEZdm5RxBcZcDZdkDlMoUmiSjnIJCqBC-r8zsqT-9AQAA8wAAAFBO.png","http://2.im.guokr.com/LP7rQy-GTTK3Prcarf-_klhWBuoZxHC1HfQRPT89d1v5AQAADQEAAFBO.png?imageView2/1/w/480/h/255","http://1.im.guokr.com/-D9HAzR4enZ5L_smtSjGZ548GXuSxqHYmuA9h8bx0O3-AQAAIAEAAFBO.png?imageView2/1/w/480/h/271"]
         * video_duration : null
         * id : 82897
         * category : humanities
         * style : article
         * title : 我是个剥削难民的器官贩子，但你得听我把话说完
         * source_data : {"image":"http://2.im.guokr.com/r8PINb_RG_niPP_rsxxvHLK7HmQE9i1NZD6pWV_0VDKgAAAAoAAAAFBO.png?imageView2/1/w/160/h/160","summary":"吸走你的无聊时间！","id":52,"key":"天了噜！","title":"天了噜！"}
         * headline_img_tb : http://1.im.guokr.com/eZob3HShd7w3lYGU7TWcCin6iJiGodALtCje1aK4TPAFAgAAHwEAAFBO.png?imageView2/1/w/288/h/159
         * link_v2 : http://jingxuan.guokr.com/pick/v2/82897/
         * date_picked : 1.49346006E9
         * is_top : false
         * link : http://jingxuan.guokr.com/pick/82897/
         * headline_img : http://1.im.guokr.com/eZob3HShd7w3lYGU7TWcCin6iJiGodALtCje1aK4TPAFAgAAHwEAAFBO.png
         * replies_count : 3
         * current_user_has_liked : false
         * page_source : c
         * author : 花生卷i
         * summary : 他叫阿布·加法（阿布 Jaafar），当然这只是一个化名。他的职业是人体器官走私贩，他的客户基本都是叙利亚难民。在这些难民的身体里
         * source : group
         * reply_root_id : 786427
         * date_created : 1.493359645E9
         */

        @SerializedName("link_v2_sync_img")
        private String linkV2SyncImg;
        @SerializedName("source_name")
        private String sourceName;
        @SerializedName("video_url")
        private String videoUrl;
        @SerializedName("current_user_has_collected")
        private boolean currentUserHasCollected;
        @SerializedName("likings_count")
        private int likingsCount;
        @SerializedName("video_duration")
        private Object videoDuration;
        @SerializedName("id")
        private int id;
        @SerializedName("category")
        private String category;
        @SerializedName("style")
        private String style;
        @SerializedName("title")
        private String title;
        @SerializedName("source_data")
        private SourceDataBean sourceData;
        @SerializedName("headline_img_tb")
        private String headlineImgTb;
        @SerializedName("link_v2")
        private String linkV2;
        @SerializedName("date_picked")
        private double datePicked;
        @SerializedName("is_top")
        private boolean isTop;
        @SerializedName("link")
        private String link;
        @SerializedName("headline_img")
        private String headlineImg;
        @SerializedName("replies_count")
        private int repliesCount;
        @SerializedName("current_user_has_liked")
        private boolean currentUserHasLiked;
        @SerializedName("page_source")
        private String pageSource;
        @SerializedName("author")
        private String author;
        @SerializedName("summary")
        private String summary;
        @SerializedName("source")
        private String source;
        @SerializedName("reply_root_id")
        private int replyRootId;
        @SerializedName("date_created")
        private double dateCreated;
        @SerializedName("images")
        private List<String> images;

        public String getLinkV2SyncImg() {
            return linkV2SyncImg;
        }

        public void setLinkV2SyncImg(String linkV2SyncImg) {
            this.linkV2SyncImg = linkV2SyncImg;
        }

        public String getSourceName() {
            return sourceName;
        }

        public void setSourceName(String sourceName) {
            this.sourceName = sourceName;
        }

        public String getVideoUrl() {
            return videoUrl;
        }

        public void setVideoUrl(String videoUrl) {
            this.videoUrl = videoUrl;
        }

        public boolean isCurrentUserHasCollected() {
            return currentUserHasCollected;
        }

        public void setCurrentUserHasCollected(boolean currentUserHasCollected) {
            this.currentUserHasCollected = currentUserHasCollected;
        }

        public int getLikingsCount() {
            return likingsCount;
        }

        public void setLikingsCount(int likingsCount) {
            this.likingsCount = likingsCount;
        }

        public Object getVideoDuration() {
            return videoDuration;
        }

        public void setVideoDuration(Object videoDuration) {
            this.videoDuration = videoDuration;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getStyle() {
            return style;
        }

        public void setStyle(String style) {
            this.style = style;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public SourceDataBean getSourceData() {
            return sourceData;
        }

        public void setSourceData(SourceDataBean sourceData) {
            this.sourceData = sourceData;
        }

        public String getHeadlineImgTb() {
            return headlineImgTb;
        }

        public void setHeadlineImgTb(String headlineImgTb) {
            this.headlineImgTb = headlineImgTb;
        }

        public String getLinkV2() {
            return linkV2;
        }

        public void setLinkV2(String linkV2) {
            this.linkV2 = linkV2;
        }

        public double getDatePicked() {
            return datePicked;
        }

        public void setDatePicked(double datePicked) {
            this.datePicked = datePicked;
        }

        public boolean isIsTop() {
            return isTop;
        }

        public void setIsTop(boolean isTop) {
            this.isTop = isTop;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getHeadlineImg() {
            return headlineImg;
        }

        public void setHeadlineImg(String headlineImg) {
            this.headlineImg = headlineImg;
        }

        public int getRepliesCount() {
            return repliesCount;
        }

        public void setRepliesCount(int repliesCount) {
            this.repliesCount = repliesCount;
        }

        public boolean isCurrentUserHasLiked() {
            return currentUserHasLiked;
        }

        public void setCurrentUserHasLiked(boolean currentUserHasLiked) {
            this.currentUserHasLiked = currentUserHasLiked;
        }

        public String getPageSource() {
            return pageSource;
        }

        public void setPageSource(String pageSource) {
            this.pageSource = pageSource;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public int getReplyRootId() {
            return replyRootId;
        }

        public void setReplyRootId(int replyRootId) {
            this.replyRootId = replyRootId;
        }

        public double getDateCreated() {
            return dateCreated;
        }

        public void setDateCreated(double dateCreated) {
            this.dateCreated = dateCreated;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }

        @Override
        public String toString() {
            return "ResultBean{" +
                    "linkV2SyncImg='" + linkV2SyncImg + '\'' +
                    ", sourceName='" + sourceName + '\'' +
                    ", videoUrl='" + videoUrl + '\'' +
                    ", currentUserHasCollected=" + currentUserHasCollected +
                    ", likingsCount=" + likingsCount +
                    ", videoDuration=" + videoDuration +
                    ", id=" + id +
                    ", category='" + category + '\'' +
                    ", style='" + style + '\'' +
                    ", title='" + title + '\'' +
                    ", sourceData=" + sourceData +
                    ", headlineImgTb='" + headlineImgTb + '\'' +
                    ", linkV2='" + linkV2 + '\'' +
                    ", datePicked=" + datePicked +
                    ", isTop=" + isTop +
                    ", link='" + link + '\'' +
                    ", headlineImg='" + headlineImg + '\'' +
                    ", repliesCount=" + repliesCount +
                    ", currentUserHasLiked=" + currentUserHasLiked +
                    ", pageSource='" + pageSource + '\'' +
                    ", author='" + author + '\'' +
                    ", summary='" + summary + '\'' +
                    ", source='" + source + '\'' +
                    ", replyRootId=" + replyRootId +
                    ", dateCreated=" + dateCreated +
                    ", images=" + images +
                    '}';
        }

        public static class SourceDataBean {
            /**
             * image : http://2.im.guokr.com/r8PINb_RG_niPP_rsxxvHLK7HmQE9i1NZD6pWV_0VDKgAAAAoAAAAFBO.png?imageView2/1/w/160/h/160
             * summary : 吸走你的无聊时间！
             * id : 52
             * key : 天了噜！
             * title : 天了噜！
             */

            @SerializedName("image")
            private String image;
            @SerializedName("summary")
            private String summary;
            @SerializedName("id")
            private int id;
            @SerializedName("key")
            private String key;
            @SerializedName("title")
            private String title;

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getSummary() {
                return summary;
            }

            public void setSummary(String summary) {
                this.summary = summary;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            @Override
            public String toString() {
                return "SourceDataBean{" +
                        "image='" + image + '\'' +
                        ", summary='" + summary + '\'' +
                        ", id=" + id +
                        ", key='" + key + '\'' +
                        ", title='" + title + '\'' +
                        '}';
            }
        }
    }
}
