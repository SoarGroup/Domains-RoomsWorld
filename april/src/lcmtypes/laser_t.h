/** THIS IS AN AUTOMATICALLY GENERATED FILE.  DO NOT MODIFY
 * BY HAND!!
 *
 * Generated by lcm-gen
 **/

#include <stdint.h>
#include <stdlib.h>
#include <lcm/lcm_coretypes.h>
#include <lcm/lcm.h>

#ifndef _laser_t_h
#define _laser_t_h

#ifdef __cplusplus
extern "C" {
#endif

typedef struct _laser_t laser_t;
struct _laser_t
{
    int64_t    utime;
    int32_t    nranges;
    float      *ranges;
    int32_t    nintensities;
    float      *intensities;
    float      rad0;
    float      radstep;
};
 
laser_t   *laser_t_copy(const laser_t *p);
void laser_t_destroy(laser_t *p);

typedef struct _laser_t_subscription_t laser_t_subscription_t;
typedef void(*laser_t_handler_t)(const lcm_recv_buf_t *rbuf, 
             const char *channel, const laser_t *msg, void *user);

int laser_t_publish(lcm_t *lcm, const char *channel, const laser_t *p);
laser_t_subscription_t* laser_t_subscribe(lcm_t *lcm, const char *channel, laser_t_handler_t f, void *userdata);
int laser_t_unsubscribe(lcm_t *lcm, laser_t_subscription_t* hid);
int laser_t_subscription_set_queue_capacity(laser_t_subscription_t* subs, 
                              int num_messages);


int  laser_t_encode(void *buf, int offset, int maxlen, const laser_t *p);
int  laser_t_decode(const void *buf, int offset, int maxlen, laser_t *p);
int  laser_t_decode_cleanup(laser_t *p);
int  laser_t_encoded_size(const laser_t *p);

// LCM support functions. Users should not call these
int64_t __laser_t_get_hash(void);
int64_t __laser_t_hash_recursive(const __lcm_hash_ptr *p);
int     __laser_t_encode_array(void *buf, int offset, int maxlen, const laser_t *p, int elements);
int     __laser_t_decode_array(const void *buf, int offset, int maxlen, laser_t *p, int elements);
int     __laser_t_decode_array_cleanup(laser_t *p, int elements);
int     __laser_t_encoded_array_size(const laser_t *p, int elements);
int     __laser_t_clone_array(const laser_t *p, laser_t *q, int elements);

#ifdef __cplusplus
}
#endif

#endif
