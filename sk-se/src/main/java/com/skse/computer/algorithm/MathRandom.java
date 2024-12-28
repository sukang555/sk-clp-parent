package com.skse.computer.algorithm;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class MathRandom {
	
	
	private Object random;



	@Test
	public  void main1() {
		Map<Object, Integer> map= new HashMap<>();
		Map<Object, String> map2 = new HashMap<>();
		
		DecimalFormat format = new DecimalFormat("0.00");
	
		List<RewardPrize> list = new ArrayList<>();
		list.add(new RewardPrize(1,1.0,284));
		list.add(new RewardPrize(2,0.7,284));
		list.add(new RewardPrize(3,0.9,284));
		list.add(new RewardPrize(4,1.5,284));
		list.add(new RewardPrize(5,1.9,284));
		list.add(new RewardPrize(6,25.0,284));
		list.add(new RewardPrize(7,30.0,284));
		list.add(new RewardPrize(8,39.0,284));
		int num = 100000;
		for (int i = 0; i < num; i++) {
			int id = percentageRandom(list);
			if (id > 0) {
				map.put(id, map.get(id) == null ? 0:map.get(id)+1);
				//System.out.println(id);
			}
		}
		System.out.println(map);
		for (int i = 1; i < 9; i++) {
			map2.put(i, format.format((double)map.get(i)/num*100));
		}
		System.out.println(map2);
	}



	/**
     * Math.random()产生一个double型的随机数，判断一下 每个奖品出现的概率
     *
     * @return int
     */
    public int percentageRandom(List<RewardPrize> prizes) {
        int random = -2;
        try{
            double sumWeight = 0;
            //计算总权重
            for(RewardPrize rp_1 : prizes){
                sumWeight += rp_1.getProbability();
            }
            double randomNumber;
            randomNumber = Math.random();
            double d1 = 0;
            double d2 = 0;

            for(int i=0;i<prizes.size();i++){
                d2 += Double.parseDouble(String.valueOf(prizes.get(i).getProbability()))/sumWeight;
                if(i==0){
                    d1 = 0;
                }else{
                    d1 +=Double.parseDouble(String.valueOf(prizes.get(i-1).getProbability()))/sumWeight;
                }
                if(randomNumber >= d1 && randomNumber <= d2){
                    random = prizes.get(i).getPrizeId();
                    break;
                }
            }
        }catch(Exception e){
        }
        return random;
    } 
}


class RewardPrize {

    /**
     * 奖品唯一标示
     */
    private Integer prizeId;

    /**
     * 中奖概率
     */
    private Double probability;

    /**
     * 奖品数量
     */
    private Integer quantity;
    
    

    public RewardPrize(Integer prizeId, Double probability, Integer quantity) {
		super();
		this.prizeId = prizeId;
		this.probability = probability;
		this.quantity = quantity;
	}

	public Integer getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(Integer prizeId) {
        this.prizeId = prizeId;
    }

    public Double getProbability() {
        return probability;
    }

    public void setProbability(Double probability) {
        this.probability = probability;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}