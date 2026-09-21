# JAVA-PROJECT-01
                 COURIER DELIVERY SYSTEM
                          │
                          ▼
                 ┌─────────────────┐
                 │ Delivery Charge │
                 │ weight → ₹50+10w│
                 └────────┬────────┘
                          │
                          ▼
                 ┌─────────────────┐
                 │ Delivery Status │
                 │ 1 → Created     │
                 │ 2 → In Transit  │
                 │ 3 → Out Delivery│
                 │ 4 → Delivered   │
                 └────────┬────────┘
                          │
                          ▼
                 ┌─────────────────┐
                 │ Delivery Check  │
                 │ distance ≤ 500? │
                 └───────┬─────────┘
                     YES │ NO
                         │
              ┌──────────┴──────────┐
              ▼                     ▼
         ┌──────────┐          ┌────────────┐
         │ Eligible │          │Not Eligible│
         └──────────┘          └────────────┘
                          │
                          ▼
                 ┌─────────────────┐
                 │ Tracking Search │
                 │ ID → Search     │
                 └────────┬────────┘
                          │
                    ┌─────┴─────┐
                    ▼           ▼
                 Found       Not Found
                          │
                          ▼
                 ┌─────────────────┐
                 │ Update Status   │
                 │ Position → New  │
                 │ Status          │
                 └────────┬────────┘
                          │
                          ▼
                 ┌─────────────────┐
                 │ Distance Report │
                 │ Total           │
                 │ Average         │
                 │ >100 km Count   │
                 └────────┬────────┘
                          │
                          ▼
                 ┌─────────────────┐
                 │ Farthest Route  │
                 │ Find Maximum    │
                 └────────┬────────┘
                          │
                          ▼
                 ┌─────────────────┐
                 │   Route Map     │
                 │   2D Array      │
                 │  0 = No Route   │
                 │  1 = Direct     │
                 └─────────────────┘
