import React from "react";
import { useDispatch, useSelector } from "react-redux";
import { decrement, increment } from "../../app/slices/counter.slice";


function Counter() {
  // Lấy ra được dữ liệu từ store va hiển thị
  const counter = useSelector((state) => state.counter.value);
  
  const dispatch = useDispatch();

  const handleDecrement = () => {
    dispatch(decrement());
  };

  const handkeIncrement = () => {
    dispatch(increment());
  };

  return (
    <>
      <h1>Counter : {counter}</h1>
      <button onClick={handleDecrement}> Decrement</button>
      <button onClick={handkeIncrement}> Increment</button>
    </>
  );
}

export default Counter;

